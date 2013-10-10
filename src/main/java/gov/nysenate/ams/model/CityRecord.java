package gov.nysenate.ams.model;

/**
 * Represents a City/State record that is populated during a city/state request.
 */
public class CityRecord
{
    protected final char detailCode;      // Copyright Detail Code
    protected final String zipCode;       // Zip code
    protected final String cityKey;       // City/state key
    protected final char zipClassCode;    // Zip classification code:
                                          //    blank = non-unique zip5
                                          //    M = APO/FPO military zip5
                                          //    P = PO BOX zip5
                                          //    U = Unique zip5

    protected final String cityName;      // City/state name
    protected final String cityAbbrev;    // City/state name abbrev
    protected final char facilityCd;      // Facility code:
                                          //    A = Airport mail facility
                                          //    B = Branch
                                          //    C = Community post office
                                          //    D = Area distrib. center
                                          //    E = Sect. center facility
                                          //    F = General distrib. center
                                          //    G = General mail facility
                                          //    K = Bulk mail center

    public char getCityDelvInd() {
        return cityDelvInd;
    }

    public char getAutoZoneInd() {
        return autoZoneInd;
    }

    public char getUniqueZipInd() {
        return uniqueZipInd;
    }

    //    M = Money order unit
                                          //    N = Non-postal name
                                          //       community name,former postal facility,or place name
                                          //    P = Post office
                                          //    S = Station
                                          //    U = Urbanization

    protected final char mailingNameInd;  // Mailing name indicator:
                                          //    Y = Mailing name
                                          //    N = Non-mailing name

    protected final String lastLineNum;   // Preferred last line key
    protected final String lastLineName;  // Preferred city name
    protected final char cityDelvInd;
    protected final char autoZoneInd;
    protected final char uniqueZipInd;
    protected final String stateAbbr;     // State abbreviation
    protected final String countyNum;     // County number
    protected final String countyName;    // County name

    public CityRecord(String countyName, String stateAbbr, String zipCode,  String lastLineName, String lastLineNum,
                      String cityAbbrev, String cityName,String cityKey, String countyNum, char zipClassCode,
                      char mailingNameInd,  char detailCode, char facilityCd, char cityDelvInd, char autoZoneind,
                      char uniqueZipInd)
    {
        this.countyName = countyName;
        this.countyNum = countyNum;
        this.stateAbbr = stateAbbr;
        this.lastLineName = lastLineName;
        this.lastLineNum = lastLineNum;
        this.mailingNameInd = mailingNameInd;
        this.facilityCd = facilityCd;
        this.cityAbbrev = cityAbbrev;
        this.cityName = cityName;
        this.zipClassCode = zipClassCode;
        this.cityKey = cityKey;
        this.zipCode = zipCode;
        this.detailCode = detailCode;
        this.cityDelvInd = cityDelvInd;
        this.autoZoneInd = autoZoneind;
        this.uniqueZipInd = uniqueZipInd;
    }

    public char getDetailCode() {
        return detailCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCityKey() {
        return cityKey;
    }

    public char getZipClassCode() {
        return zipClassCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityAbbrev() {
        return cityAbbrev;
    }

    public char getFacilityCd() {
        return facilityCd;
    }

    public char getMailingNameInd() {
        return mailingNameInd;
    }

    public String getLastLineNum() {
        return lastLineNum;
    }

    public String getLastLineName() {
        return lastLineName;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public int getCountyNo() {
        return countyNum;
    }

    public String getCountyName() {
        return countyName;
    }
}