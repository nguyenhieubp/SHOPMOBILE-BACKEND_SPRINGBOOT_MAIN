package com.example.MobileShop.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IReviewRepository extends JpaRepository<Review, UUID> {
}

