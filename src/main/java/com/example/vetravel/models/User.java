package com.example.vetravel.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @NotNull(message = "Password must have length 8")
    @Size(min = 3,message = "Username must have length 3")
    private String username;
    @NotNull
    private String email;
    @NotNull(message = "Password must have length 8")
    @Size(min = 8)
    private String password;
    private String prevPassword;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
