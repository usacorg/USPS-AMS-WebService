package gov.nysenate.ams.controller;

import gov.nysenate.ams.client.response.BaseAddressInquiryResponse;
import gov.nysenate.ams.client.response.BatchResponse;
import gov.nysenate.ams.client.response.DetailAddressInquiryResponse;
import gov.nysenate.ams.client.response.USACInquiryResponse;
import gov.nysenate.ams.filter.ApiFilter;
import gov.nysenate.ams.model.Address;
import gov.nysenate.ams.model.AddressInquiryResult;
import gov.nysenate.ams.provider.AmsNativeProvider;
import gov.nysenate.ams.util.Application;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet to handle address validation requests.
 */
public class USACValidateController extends BaseApiController
{
    private Logger logger = Logger.getLogger(AddressValidateController.class);
    private AmsNativeProvider amsNativeProvider;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        this.amsNativeProvider = Application.getAmsNativeProvider();
        logger.debug("Initialized AddressValidateController.");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException
    {
        doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object responseObj;

        Address inputAddress = getAddressFromUSACParams(request);
        boolean detail = isDetail(request);
        boolean initCaps = isInitCaps(request);

        String result = amsNativeProvider.usacInquiry(inputAddress);
	logger.info(result);

        responseObj = new USACInquiryResponse(result);
        request.setAttribute("format", "USAC");

        ApiFilter.setApiResponse(responseObj, request);
    }
}
