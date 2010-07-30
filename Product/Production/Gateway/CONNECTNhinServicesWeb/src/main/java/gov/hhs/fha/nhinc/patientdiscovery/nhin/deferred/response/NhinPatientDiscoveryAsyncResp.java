package gov.hhs.fha.nhinc.patientdiscovery.nhin.deferred.response;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author JHOPPESC
 */
@WebService(serviceName = "RespondingGatewayDeferredResp_Service", portName = "RespondingGatewayDeferredResponse_Port", endpointInterface = "ihe.iti.xcpd._2009.RespondingGatewayDeferredResponsePortType", targetNamespace = "urn:ihe:iti:xcpd:2009", wsdlLocation = "WEB-INF/wsdl/NhinPatientDiscoveryAsyncResp/NhinPatientDiscoveryDeferredResponse.wsdl")
@BindingType(value = "http://www.w3.org/2003/05/soap/bindings/HTTP/")
public class NhinPatientDiscoveryAsyncResp {
    @Resource
    private WebServiceContext context;

    public org.hl7.v3.MCCIIN000002UV01 respondingGatewayDeferredPRPAIN201306UV02(org.hl7.v3.PRPAIN201306UV02 body) {
        return new NhinPatientDiscoveryAsyncRespImpl().respondingGatewayPRPAIN201306UV02(body, context);
    }

}