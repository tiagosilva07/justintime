package pt.ipca.justintime.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import pt.ipca.justintime.domain.Address;
import pt.ipca.justintime.domain.Contact;
import pt.ipca.justintime.domain.Gender;
import pt.ipca.justintime.domain.Project;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiago Silva
 * @class LESI-PL 3º Ano
 * @number a7809
 * @email a7809@alunos.ipca.pt
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientForm {

    private Long id;

    private String firstName;

    private String lastName;

    @NotNull
    @Min(value = 000000000)
    @Max(value = 999999999)
    private Integer nif;
    /**
     * ^	#start of the line
     * [_A-Za-z0-9-\\+]+ #  must start with string in the bracket [ ], must contains one or more
     * (# start of group #1
     * \\.[_A-Za-z0-9-]+ # follow by a dot "." and string in the bracket [ ], must contains one or more)
     * *#   end of group #1, this group is optional (*)
     * ***********************************************
     *
     * @# must contains a "@" symbol
     * [A-Za-z0-9-]+ #follow by string in the bracket [ ], must contains one or more
     * ************************************************
     * #start of group #2 - first level checking
     * \\(.[A-Za-z0-9]+ # follow by a dot "." and string in the bracket [ ], must contains one or more)
     * #end of group #2, this group is optional (*)
     * *************************************************
     * #start of group #3 - second level checking
     * #\\.[A-Za-z]{2,}  #follow by a dot "." and string in the bracket [ ], with minimum length of 2)
     * #end of group #3
     * $#end of the line
     */
    @NotEmpty
    @Email
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "Please insert a valid email")
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Address addressOne;

    private Address addressTwo;

    private List<Contact> contactList;

    private List<Project> projectList = new ArrayList<>();


}
