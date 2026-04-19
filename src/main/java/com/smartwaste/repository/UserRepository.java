package com.smartwaste.repository;

import com.smartwaste.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository untuk entitas {@link User} (abstract).
 * Digunakan oleh UserDetailsServiceImpl untuk autentikasi.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /** Mencari user berdasarkan email (digunakan saat login). */
    Optional<User> findByEmail(String email);

    /** Mengecek apakah email sudah terdaftar (untuk validasi registrasi). */
    boolean existsByEmail(String email);

    /** Mencari user aktif berdasarkan email. */
    @Query("SELECT u FROM User u WHERE u.email = :email AND u.active = true")
    Optional<User> findActiveByEmail(String email);
}
