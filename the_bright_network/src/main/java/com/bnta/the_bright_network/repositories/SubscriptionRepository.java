package com.bnta.the_bright_network.repositories;

import com.bnta.the_bright_network.models.Message;
import com.bnta.the_bright_network.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
