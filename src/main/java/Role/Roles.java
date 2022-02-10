package Role;

import java.util.ArrayList;
import java.util.List;

public class Roles {

    public static final String ROLE_ADMIN = "Admin";
    public static final String ROLE_EMPLOYEE = "Employee";

    public static final String MEMBER_USER = "Users";

    public static final List<String> MEMBER_TYPES = new ArrayList<String>() {{
        add(MEMBER_USER );

    }};

    public static final Integer BOOK_STATUS_AVAILABLE = 1;
    public static final Integer BOOK_STATUS_ISSUED = 2;

    public static final Integer BOOK_NOT_RETURNED = 0;
    public static final Integer BOOK_RETURNED = 1;
}

