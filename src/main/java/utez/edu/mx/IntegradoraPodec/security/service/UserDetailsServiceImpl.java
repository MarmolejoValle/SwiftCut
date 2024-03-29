package utez.edu.mx.IntegradoraPodec.security.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Services.Employees.EmployeesService;
import utez.edu.mx.IntegradoraPodec.security.model.UserDetailsImpl;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final EmployeesService service;

    public UserDetailsServiceImpl(EmployeesService service) {
        this.service = service;
    }
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeesBean> foundUser = service.getRepository().findByEmail(username);
     //   System.out.println("Bloked : " + foundUser.get().getBlocked());
      //  System.out.println("Emmail : " + foundUser.get().getEmail());

        if (foundUser.isPresent())
            return UserDetailsImpl.build(foundUser.get());
        throw new UsernameNotFoundException("UserNotFound");
    }
}
