package utez.edu.mx.IntegradoraPodec.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import utez.edu.mx.IntegradoraPodec.Model.Employees.EmployeesBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails{
    private String username;
    private String password;
    private boolean blocked;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(String username, String password, boolean blocked, boolean enabled, String type) {
        this.username = username;
        this.password = password;
        this.blocked = blocked;
        this.enabled = enabled;
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(type));
        this.authorities = authorities;

    }

    public static UserDetailsImpl build(EmployeesBean user){

        return new UserDetailsImpl(
                user.getEmail(), user.getPassword(),
                user.getBlocked(), user.getStatus(),user.getRolsBean().getType()
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
