package factory;

import constant.Constants;
import service.*;
import service.impl.*;

public class UserSearching {
    public static ISearch createISEARCH(int flag) {
        switch (flag) {
            case Constants.SEARCH_BY_USERNAME:
                return new SearchByUsername();
            case Constants.SEARCH_BY_FULL_NAME:
                return new SearchByFullName();
            case Constants.SEARCH_BY_EMAIL:
                return new SearchByEmail();
            case Constants.SEARCH_BY_DEPARTMENT:
                return new SearchByDepartment();
            case Constants.SEARCH_BY_RESIDENCY:
                return new SearchByResidency();
            default:
                return null;
        }
        //do-while!
    }
}
