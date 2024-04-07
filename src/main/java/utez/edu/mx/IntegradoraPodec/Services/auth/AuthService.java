package utez.edu.mx.IntegradoraPodec.Services.auth;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Config.ApiResponse;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesDto;
import utez.edu.mx.IntegradoraPodec.Services.Customer.CustomerService;
import utez.edu.mx.IntegradoraPodec.Services.Employees.EmployeesService;
import utez.edu.mx.IntegradoraPodec.security.jwt.JwtProvider;

import java.util.Optional;


@Service
@Transactional
public class AuthService {
    private final EmployeesService userService;
    private final CustomerService userServiceClients;


    private final JwtProvider provider;
    private final AuthenticationManager manager;

    public AuthService(EmployeesService userService, CustomerService userServiceClients, JwtProvider provider, AuthenticationManager manager) {
        this.userService = userService;
        this.userServiceClients = userServiceClients;
        this.provider = provider;
        this.manager = manager;
    }

    @Transactional
    public ResponseEntity<ApiResponse> signIn(String username, String password) {
        try {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            Optional<EmployeesBean> foundUser = userService.getRepository().findByEmail(username);
            if (foundUser.isEmpty())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFound"), HttpStatus.BAD_REQUEST);
            if (!bcrypt.matches(password, foundUser.get().getPassword()))
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFoundPass"), HttpStatus.BAD_REQUEST);


            EmployeesBean user = foundUser.get();

                if (user.getPersonBean().getStatusPersonBean().getType().equals("Baja"))
                    return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotEnabled"), HttpStatus.BAD_REQUEST);
                if (user.getPersonBean().getStatusPersonBean().getType().equals("Bloqueado"))
                    return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserBlocked"), HttpStatus.BAD_REQUEST);
                System.out.println(new UsernamePasswordAuthenticationToken(username, password));
                Authentication auth = manager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
                String token = provider.generateToken(auth);
                // Payload - DTO (token, attrs)

            EmployeesDto dto = new EmployeesDto(user.getId(),user.getEmail(),  token);


            return new ResponseEntity<>(new ApiResponse(dto, HttpStatus.OK,"Token generado"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "CredentialsMismatch";
            if (e instanceof DisabledException)
                message = "UserDisabled";
            if (e instanceof AccountExpiredException)
                message = "Expiro";
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, message), HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<ApiResponse> signInClients(String username, String password) {
        try {
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            Optional<CustomersBean> foundUser = userServiceClients.getRepository().findByEmail(username);
            if (foundUser.isEmpty())
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFound"), HttpStatus.BAD_REQUEST);
            if (!bcrypt.matches(password, foundUser.get().getPassword()))
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotFoundPass"), HttpStatus.BAD_REQUEST);


            CustomersBean user = foundUser.get();
            if (user.getPersonBean().getStatusPersonBean().getType().equals("Baja"))
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserNotEnabled"), HttpStatus.BAD_REQUEST);
            if (user.getPersonBean().getStatusPersonBean().getType().equals("Bloqueado"))
                return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, "UserBlocked"), HttpStatus.BAD_REQUEST);
            System.out.println(new UsernamePasswordAuthenticationToken(username, password));
            Authentication auth = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = provider.generateToken(auth);
            // Payload - DTO (token, attrs)



            return new ResponseEntity<>(new ApiResponse(userServiceClients.findByEmail(username , token), HttpStatus.OK,"Token generado"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            String message = "CredentialsMismatch";
            if (e instanceof DisabledException)
                message = "UserDisabled";
            if (e instanceof AccountExpiredException)
                message = "Expiro";
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST, true, message), HttpStatus.UNAUTHORIZED);
        }
    }


}
