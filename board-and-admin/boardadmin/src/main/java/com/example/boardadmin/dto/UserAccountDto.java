package com.example.boardadmin.dto;

<<<<<<< HEAD
=======
import com.example.boardadmin.domain.AdminAccount;
import com.example.boardadmin.domain.constant.RoleType;

>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
import java.time.LocalDateTime;

public record UserAccountDto(
        String userId,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static UserAccountDto of(String userId, String email, String nickname, String memo) {
        return UserAccountDto.of(userId, email, nickname, memo, null, null, null, null);
    }

    public static UserAccountDto of(String userId, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(userId, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

<<<<<<< HEAD
}
=======
    public static UserAccountDto from(AdminAccount entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getRoleTypes(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public AdminAccount toEntity() {
        return AdminAccount.of(
                userId,
                userPassword,
                roleTypes,
                email,
                nickname,
                memo
        );
    }

}
>>>>>>> afe78be51f842943efb30446e0adf2625baf151f
