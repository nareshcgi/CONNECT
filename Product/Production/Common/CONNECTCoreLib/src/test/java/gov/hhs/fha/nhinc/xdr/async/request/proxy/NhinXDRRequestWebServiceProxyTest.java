package gov.hhs.fha.nhinc.xdr.async.request.proxy;

import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.common.nhinccommon.NhinTargetSystemType;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants;
import gov.hhs.healthit.nhin.XDRAcknowledgementType;
import ihe.iti.xdr._2007.XDRDeferredRequestService;
import ihe.iti.xdr._2007.XDRDeferredRequestPortType;
import ihe.iti.xds_b._2007.ProvideAndRegisterDocumentSetRequestType;
import oasis.names.tc.ebxml_regrep.xsd.rs._3.RegistryResponseType;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.apache.commons.logging.Log;

/**
 *
 * @author Neil Webb
 */
public class NhinXDRRequestWebServiceProxyTest {

    private Mockery context;

    @Before
    public void setUp() {
        context = new Mockery() {

            {
                setImposteriser(ClassImposteriser.INSTANCE);
            }
        };
    }

    @Test
    public void testProvideAndRegisterDocumentSetBRequest() {
        final Log mockLogger = context.mock(Log.class);
        final XDRDeferredRequestService mockService = context.mock(XDRDeferredRequestService.class);

        NhinXDRRequestWebServiceProxy proxy = new NhinXDRRequestWebServiceProxy() {

            @Override
            protected Log createLogger() {
                return mockLogger;
            }

            @Override
            protected String getUrl(NhinTargetSystemType target) {
                return "Mock URL";
            }

            @Override
            protected XDRDeferredRequestPortType getPort(String url) {
                XDRDeferredRequestPortType mockPort = new XDRDeferredRequestPortType() {

                    public XDRAcknowledgementType provideAndRegisterDocumentSetBDeferredRequest(ProvideAndRegisterDocumentSetRequestType arg0) {
                        XDRAcknowledgementType ack = new XDRAcknowledgementType();
                        RegistryResponseType regResp = new RegistryResponseType();
                        regResp.setStatus("Mock Success");
                        ack.setMessage(regResp);
                        return ack;
                    }
                };
                return mockPort;
            }

            @Override
            protected void setRequestContext(AssertionType assertion, String url, XDRDeferredRequestPortType port) {
            }

            @Override
            protected XDRDeferredRequestService createService() {
                return mockService;
            }
        };

        context.checking(new Expectations() {

            {
                allowing(mockLogger).info(with(any(String.class)));
                allowing(mockLogger).debug(with(any(String.class)));
                allowing(mockLogger).error(with(any(String.class)));
                will(returnValue(null));
            }
        });

        ProvideAndRegisterDocumentSetRequestType request = null;
        AssertionType assertion = null;
        NhinTargetSystemType targetSystem = null;

        XDRAcknowledgementType ack = proxy.provideAndRegisterDocumentSetBRequest(request, assertion, targetSystem);
        assertNotNull("Ack was null", ack);
        assertEquals("Ack value", "Mock Success", ack.getMessage().getStatus());
    }
}