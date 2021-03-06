/**
 * 
 */
package gov.hhs.fha.nhinc.connectmgr;

import static org.junit.Assert.*;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants.GATEWAY_API_LEVEL;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants.NHIN_SERVICE_NAMES;
import gov.hhs.fha.nhinc.nhinclib.NhincConstants.UDDI_SPEC_VERSION;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author mweaver
 *
 */
public class ADSpecVersionRegistryTest {

    @Test
    public void testGetSupportedSpecs_g0_AD() {
        GATEWAY_API_LEVEL api = GATEWAY_API_LEVEL.LEVEL_g0;
        ArrayList<UDDI_SPEC_VERSION> list = UddiSpecVersionRegistry.getInstance().getSupportedSpecs(api, NHIN_SERVICE_NAMES.ADMINISTRATIVE_DISTRIBUTION);
        assertTrue(list.contains(UDDI_SPEC_VERSION.SPEC_1_0));
        assertTrue(!list.contains(UDDI_SPEC_VERSION.SPEC_2_0));
    }

    @Test
    public void testGetSupportedSpecs_g1_AD() {
        GATEWAY_API_LEVEL api = GATEWAY_API_LEVEL.LEVEL_g1;
        ArrayList<UDDI_SPEC_VERSION> list = UddiSpecVersionRegistry.getInstance().getSupportedSpecs(api, NHIN_SERVICE_NAMES.ADMINISTRATIVE_DISTRIBUTION);
        assertTrue(list.contains(UDDI_SPEC_VERSION.SPEC_2_0));
        assertTrue(!list.contains(UDDI_SPEC_VERSION.SPEC_1_0));
    }
}
