package engineeringthesis.androidrestapi.account.domain;

import engineeringthesis.androidrestapi.common.entity.AbstractUUIDEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@FieldNameConstants
@Table(name = "role")
class AccountRole extends AbstractUUIDEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Setter(AccessLevel.NONE)
    List<Account> users = new ArrayList<>();

    public void addRole(final Account account) {
        users.add(account);
        account.setRole(this);
    }

    public void removeRole(final Account account) {
        users.remove(account);
        account.setRole(null);
    }
}
