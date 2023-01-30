package pl.sparkmc.sparkmcwings.data.factory.impl;

import org.bukkit.entity.Player;
import pl.sparkmc.sparkmcwings.data.factory.UserFactory;
import pl.sparkmc.sparkmcwings.user.User;
import pl.sparkmc.sparkmcwings.wings.impl.Wings;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserFactoryImpl implements UserFactory {

    private final Map<UUID, User> usersMap;


    public UserFactoryImpl() {
        this.usersMap = new HashMap<>();
    }






    @Override
    public Optional<User> findByName(String name) {
        return this.usersMap
                .values()
                .stream()
                .filter(user -> user.getPlayer().getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<User> findByUniqueId(UUID uuid) {
        return Optional.of(this.usersMap.get(uuid));
    }

    @Override
    public Optional<User> findByWings(Wings wings) {
        return this.usersMap
                .values()
                .stream()
                .filter(user -> user.getWings().equals(wings))
                .findFirst();
    }

    @Override
    public Optional<User> findByPlayer(Player player) {
        return this.usersMap
                .values()
                .stream()
                .filter(user -> user.getPlayer().equals(player))
                .findFirst();
    }

    @Override
    public Optional<User> findByWings(String wings) {
        return this.usersMap
                .values()
                .stream()
                .filter(user -> user.getWings().getName().equals(wings))
                .findFirst();
    }
}
