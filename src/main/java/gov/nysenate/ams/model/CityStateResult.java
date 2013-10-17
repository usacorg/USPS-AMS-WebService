package gov.nysenate.ams.model;

/**
 * This class holds the city state result, from which you can tell if the result was successful or not.
 */

public class CityStateResult
{
    protected CityRecord result; //Holds the result from CityState look up.

    protected int responseCode;   //Returns true if the look up was a success.

    public CityStateResult(int responseCode, CityRecord result)
    {
       this.responseCode = responseCode;
       this.result = result;
    }


    /**
     * This method tell if the lookup was a success. (0=success 1=Failure 2=Couldn't connect)
     * @return boolean is true if successful, is false if otherwise.
     */
    public boolean isSuccess()
    {
        return (responseCode == 0);
    }

    public CityRecord getResult() {
        return result;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
