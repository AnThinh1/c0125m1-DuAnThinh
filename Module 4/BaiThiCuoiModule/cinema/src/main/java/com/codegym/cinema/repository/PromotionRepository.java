    package com.codegym.cinema.repository;

    import com.codegym.cinema.model.Promotion;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.time.LocalDate;
    import java.util.List;

    @Repository
    public interface PromotionRepository extends JpaRepository<Promotion, Long> {

        @Query("SELECT p FROM Promotion p " +
                "WHERE (:discount IS NULL OR p.discount = :discount) " +
                "AND (" +
                "   (:startDate IS NOT NULL AND :endDate IS NOT NULL AND p.startDate <= :endDate AND p.endDate >= :startDate) " +
                "   OR (:startDate IS NOT NULL AND :endDate IS NULL AND p.endDate >= :startDate) " +
                "   OR (:startDate IS NULL AND :endDate IS NOT NULL AND p.startDate <= :endDate) " +
                "   OR (:startDate IS NULL AND :endDate IS NULL)" +
                ")")
        List<Promotion> searchByDiscountAndDateRange(
                @Param("discount") Long discount,
                @Param("startDate") LocalDate startDate,
                @Param("endDate") LocalDate endDate);
    }
