/*
 * Copyright (c) 2014, United States Government, as represented by the Secretary of Health and Human Services.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above
 *       copyright notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the documentation
 *       and/or other materials provided with the distribution.
 *     * Neither the name of the United States Government nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE UNITED STATES GOVERNMENT BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.hhs.fha.nhinc.corex12.docsubmission.realtime.adapter;

import gov.hhs.fha.nhinc.common.nhinccommon.AssertionType;
import gov.hhs.fha.nhinc.util.Base64Coder;
import org.apache.log4j.Logger;
import org.caqh.soap.wsdl.corerule2_2_0.COREEnvelopeRealTimeRequest;
import org.caqh.soap.wsdl.corerule2_2_0.COREEnvelopeRealTimeResponse;

/**
 * @author cmay
 *
 */
public class AdapterCORE_X12DSRealTimeOrchImpl {

    private static final Logger LOG = Logger.getLogger(AdapterCORE_X12DSRealTimeOrchImpl.class);

    /**
     *
     * @param coreEnvelopeRealTimeRequest
     * @param assertion
     * @return
     */
    public COREEnvelopeRealTimeResponse realTimeRequest(COREEnvelopeRealTimeRequest coreEnvelopeRealTimeRequest, AssertionType assertion) {

        COREEnvelopeRealTimeResponse oResponse = null;
        if (coreEnvelopeRealTimeRequest != null) {
            LOG.trace("Begin AdapterCORE_X12DSRealTimeOrchImpl.realTimeRequest()");
            oResponse = buildAdapterCORE_X12DSRealTimeResponseMetadata();
            createAdapterCORE_X12DSRealTimeRequestLogInfo(coreEnvelopeRealTimeRequest);
            LOG.trace("End AdapterCORE_X12DSRealTimeOrchImpl.realTimeRequest()");
        } else {
            return oResponse;
            //TODO: Need to add error handling
        }
        return oResponse;
    }

    /**
     *
     * @return
     */
    private COREEnvelopeRealTimeResponse buildAdapterCORE_X12DSRealTimeResponseMetadata() {
        COREEnvelopeRealTimeResponse oResponse = new COREEnvelopeRealTimeResponse();
        oResponse.setPayloadType("X12_278_Response_005010X279A1");
        oResponse.setProcessingMode("RealTime");
        oResponse.setPayloadID("a81d44ae-7dec-11d0-a765-00a0c91e6ba0");
        oResponse.setTimeStamp("2007-08-30T10:20:34Z");
        oResponse.setSenderID("PayerB");
        oResponse.setReceiverID("HospitalA");
        oResponse.setCORERuleVersion("2.2.0");
        oResponse.setPayload("PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxDbGluaWNhbERvY3VtZW50\n"
            + "IG1vb2RDb2RlPSJFVk4iIHhtbG5zPSJ1cm46aGw3LW9yZzp2MyINCiAgICB4bWxuczp4c2k9Imh0");
        return oResponse;
    }

    /**
     *
     * @param coreEnvelopeRealTimeRequest
     */
    private void createAdapterCORE_X12DSRealTimeRequestLogInfo(COREEnvelopeRealTimeRequest coreEnvelopeRealTimeRequest) {
        LOG.info("CORE Paylod Type = " + coreEnvelopeRealTimeRequest.getPayloadType());
        LOG.info("CORE Processing Mode = " + coreEnvelopeRealTimeRequest.getProcessingMode());
        LOG.info("CORE Payload Id = " + coreEnvelopeRealTimeRequest.getPayloadID());
        LOG.info("CORE TimeStamp = " + coreEnvelopeRealTimeRequest.getTimeStamp());
        LOG.info("CORE Sender Id = " + coreEnvelopeRealTimeRequest.getSenderID());
        LOG.info("CORE Receiver Id = " + coreEnvelopeRealTimeRequest.getReceiverID());
        LOG.info("CORE Rule version = " + coreEnvelopeRealTimeRequest.getCORERuleVersion());
        LOG.info("CORE Payload = " + Base64Coder.decodeString(coreEnvelopeRealTimeRequest.getPayload()));
    }

}
