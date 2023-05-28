package authentification;

import lombok.*;
import org.apache.catalina.connector.Response;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse extends Response {

    private String token;
}
