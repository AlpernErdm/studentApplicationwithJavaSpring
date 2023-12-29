package codeDev.io.ogrenciBasvuru.entities;

import codeDev.io.ogrenciBasvuru.business.responses.GetByIdResultDocumentResponse;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(min = 3,max = 20,message = "The name can be between 3 and 20 characters")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "createDate")
    @CreatedDate
    private Date createDate;

    @Column(name = "lastModified")
    @LastModifiedDate
    private Date lastModified;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "role") //admin/user
    private String role;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Application>applications =new ArrayList<>();


}
