package gov.nysenate.ams.client.response;

import gov.nysenate.ams.client.view.AddressRecordView;
import gov.nysenate.ams.client.view.USPSDetailView;
import gov.nysenate.ams.model.AddressInquiryResult;
import gov.nysenate.ams.model.AddressRecord;

import java.util.ArrayList;
import java.util.List;

public class DetailAddressInquiryResponse extends BaseAddressInquiryResponse
{
    protected USPSDetailView detail;
    protected int recordCount;
    protected List<AddressRecordView> records = new ArrayList<AddressRecordView>();

    public DetailAddressInquiryResponse(AddressInquiryResult result, boolean initCaps) {
        super(result, initCaps);
        if (result != null) {
            this.detail = new USPSDetailView(result.getUspsAddress());
            this.recordCount = result.getRecords().size();
            for (AddressRecord addressRecord : result.getRecords()) {
                this.records.add(new AddressRecordView(addressRecord));
            }
        }
    }

    public USPSDetailView getDetail() {
        return detail;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public List<AddressRecordView> getRecords() {
        return records;
    }
}
