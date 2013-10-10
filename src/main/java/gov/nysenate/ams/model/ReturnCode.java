package gov.nysenate.ams.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the return codes returned by the AmsNativeProvider API.
 */
public enum ReturnCode
{
    INVALID_DUAL_ADDRESS (10,
        "Information presented could not be processed in current format. Corrective action is needed. Be sure that " +
        "the address line components are correct. For example, the input address line may contain more than one " +
        "delivery address."),

    INVALID_CITY_ST_ZIP (11,
        "The ZIP Code in the submitted address could not be found because neither a valid city, state, nor valid 5- " +
        "digit ZIP Code was present. Corrective action is needed. It is also recommended that the requestor check " +
        "the submitted address for accuracy."),

    INVALID_STATE (12,
        "The state in the submitted address is invalid. Corrective action is needed. It is also recommended that the " +
        "requestor check the submitted address for accuracy."),

    INVALID_CITY (13,
        "The city in the submitted address is invalid. Corrective action is needed. It is also recommended that the " +
        "requestor check the submitted address for accuracy."),

    NOT_FOUND (21,
        "The address, exactly as submitted, could not be found in the national ZIP+4 file. It is recommended that the " +
        "requestor check the submitted address for accuracy. For example, the street address line may be abbreviated " +
        "excessively and may not be fully recognizable."),

    MULTI_RESPONSE (22,
        "More than one ZIP+4 Code was found to satisfy the address submitted. The submitted address did not " +
        "contain sufficiently complete or correct data to determine a single ZIP+4 Code. It is recommended that the " +
        "requestor check the address for accuracy and completeness. Address elements may be missing"),

    EXACT_MATCH (31,
        "Single response based on input information. No corrective action is needed since an exact match was found " +
        "in the national ZIP+4 file."),

    DEFAULT_MATCH (32,
        "A match was made to a default record in the national ZIP+4 file. A more specific match may be available if " +
        "a secondary number (i.e., apartment, suite, etc.) exists.");

    /** Used for lookups by code. */
    private static final Map<Integer, String> codeMap = new HashMap<>();
    static {
        for (ReturnCode rc : ReturnCode.values()) {
            codeMap.put(rc.code, rc.name());
        }
    }

    /** Numerical return code. */
    private int code = 0;

    /** Description of return code and possible corrective actions. */
    private String message = "";

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Returns the ReturnCode using the numerical code.
     * @param code int
     * @return ReturnCode if code matches, null otherwise.
     */
    public static ReturnCode getByCode(int code) {
        if (codeMap.containsKey(code)) {
            return ReturnCode.valueOf(codeMap.get(code));
        }
        return null;
    }
}
