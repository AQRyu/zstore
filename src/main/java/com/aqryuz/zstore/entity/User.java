package com.aqryuz.zstore.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails{
	private static final long serialVersionUID = -4014609327966639395L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	@JsonIgnore
	private String password;
	private String address;
	private String city;
	private String phone;
	private boolean enabled;
	private LocalDateTime expiredDate;
	@Transient
	private Integer month;
	@Transient
	private String type;

	@ManyToOne(optional = false)
	@JoinColumn(name="role_id", nullable=false)
	private Role role;

	@Transient
    private Collection<? extends GrantedAuthority> grantedAuthorities;
	
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.grantedAuthorities;
	}
	
	public void setAuthorities(List<GrantedAuthority> grantedList) {
		this.grantedAuthorities = grantedList;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
