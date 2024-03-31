package utez.edu.mx.IntegradoraPodec.security.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.IntegradoraPodec.Model.Customers.CustomersBean;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;
import utez.edu.mx.IntegradoraPodec.Services.Customer.CustomerService;
import utez.edu.mx.IntegradoraPodec.Services.Employees.EmployeesService;
import utez.edu.mx.IntegradoraPodec.security.model.UserDetailsImpl;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final EmployeesService service;
    private final CustomerService serviceClient;


    public UserDetailsServiceImpl(EmployeesService service, CustomerService serviceClient) {
        this.service = service;
        this.serviceClient = serviceClient;
    }
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<EmployeesBean> foundUser = service.getRepository().findByEmail(username);

        if (foundUser.isPresent())
            return UserDetailsImpl.build(foundUser.get());

        Optional<CustomersBean> foundClient = serviceClient.getRepository().findByEmail(username);
        if (foundClient.isPresent())
            return UserDetailsImpl.buildClient(foundClient.get());
      //  System.out.println("Emmail : " + foundUser.get().getEmail());


        throw new UsernameNotFoundException("UserNotFound");
    }
}
