package pl.sparkmc.sparkmcwings.data.factory;

import org.bukkit.entity.Player;
import pl.sparkmc.sparkmcwings.user.User;
import pl.sparkmc.sparkmcwings.wings.Wings;

import java.util.Optional;
import java.util.UUID;

public interface UserFactory {

    Optional<User> findByName(String name);

    Optional<User> findByUniqueId(UUID uuid);

    Optional<User> findByWings(Wings wings);

    Optional<User> findByWings(String wings);

    Optional<User> findByPlayer(Player player);

    void registerUser(Player player);

    void unregisterUser(User user);
}
