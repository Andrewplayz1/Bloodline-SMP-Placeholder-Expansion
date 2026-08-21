package dev.bloodline.placeholders;

import dev.whiskers.bloodline.BloodlinePlugin;
import dev.whiskers.bloodline.model.BloodlineType;
import dev.whiskers.bloodline.model.PlayerProfile;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public final class BloodlineExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "bloodline";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Andrewplayz1";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getRequiredPlugin() {
        return "BloodlineSMP";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin("BloodlineSMP") != null;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return "";
        }

        BloodlinePlugin plugin =
                (BloodlinePlugin) Bukkit.getPluginManager()
                        .getPlugin("BloodlineSMP");

        if (plugin == null || plugin.getPlayerDataManager() == null) {
            return "";
        }

        PlayerProfile profile =
                plugin.getPlayerDataManager()
                        .getOrCreate(player.getUniqueId());

        if (profile == null) {
            return "";
        }

        String key = params.toLowerCase(Locale.ROOT);

        if (key.equals("uuid")) {
            return player.getUniqueId().toString();
        }

        if (key.equals("active")) {
            BloodlineType active = profile.activeBloodline();

            if (active == null) {
                return "";
            }

            return active.name();
        }

        if (key.equals("active_name")) {
            return formatBloodline(profile.activeBloodline());
        }

        if (key.equals("active_level")) {
            if (profile.activeBloodline() == null) {
                return "0";
            }

            return String.valueOf(profile.activeLevel());
        }

        if (key.startsWith("level_")) {
            BloodlineType type = findBloodline(
                    key.substring("level_".length())
            );

            if (type == null) {
                return "";
            }

            return String.valueOf(profile.level(type));
        }

        if (key.startsWith("owns_")) {
            BloodlineType type = findBloodline(
                    key.substring("owns_".length())
            );

            if (type == null) {
                return "";
            }

            return String.valueOf(profile.owns(type));
        }

        if (key.startsWith("is_")) {
            BloodlineType type = findBloodline(
                    key.substring("is_".length())
            );

            if (type == null) {
                return "";
            }

            return Boolean.toString(profile.activeBloodline() == type);
        }

        if (key.equals("list")) {
            return Arrays.stream(BloodlineType.values())
                    .map(this::formatBloodline)
                    .collect(Collectors.joining(", "));
        }

        if (key.equals("count")) {
            return String.valueOf(BloodlineType.values().length);
        }

        if (key.startsWith("exists_")) {
            return Boolean.toString(
                    findBloodline(
                            key.substring("exists_".length())
                    ) != null
            );
        }

        if (key.equals("all_base_maxed")) {
            return Boolean.toString(
                    profile.hasAllBaseBloodlinesAtMax()
            );
        }

        if (key.equals("fresh_assignment")) {
            return Boolean.toString(
                    profile.freshAssignmentPending()
            );
        }

        if (key.equals("omni_blade_locked")) {
            return Boolean.toString(
                    profile.omniBladeSpectatorLocked()
            );
        }

        if (key.startsWith("cooldown_remaining_")) {
            String cooldown =
                    key.substring("cooldown_remaining_".length());

            if (cooldown.isEmpty()) {
                return "0";
            }

            long until = profile.getCooldown(cooldown);

            return String.valueOf(
                    Math.max(
                            0L,
                            until - System.currentTimeMillis()
                    )
            );
        }

        if (key.startsWith("cooldown_")) {
            String cooldown =
                    key.substring("cooldown_".length());

            if (cooldown.isEmpty()) {
                return "0";
            }

            return String.valueOf(
                    profile.getCooldown(cooldown)
            );
        }

        if (key.equals("spartan_flaming_hands_until")) {
            return String.valueOf(
                    profile.spartanFlamingHandsUntil()
            );
        }

        if (key.equals("spartan_flaming_hands_remaining")) {
            return String.valueOf(
                    Math.max(
                            0L,
                            profile.spartanFlamingHandsUntil()
                                    - System.currentTimeMillis()
                    )
            );
        }

        if (key.equals("spartan_flaming_hands")) {
            return Boolean.toString(
                    profile.spartanFlamingHandsUntil()
                            > System.currentTimeMillis()
            );
        }

        if (key.equals("spartan_cursed_by")) {
            if (profile.cursedBySpartan() == null) {
                return "";
            }

            return profile.cursedBySpartan().toString();
        }

        if (key.equals("spartan_cursed_until")) {
            return String.valueOf(
                    profile.cursedUntil()
            );
        }

        if (key.equals("spartan_cursed_remaining")) {
            return String.valueOf(
                    Math.max(
                            0L,
                            profile.cursedUntil()
                                    - System.currentTimeMillis()
                    )
            );
        }

        if (key.equals("spartan_cursed")) {
            return Boolean.toString(
                    profile.cursedUntil()
                            > System.currentTimeMillis()
            );
        }

        if (key.equals("void_send_charges")) {
            return String.valueOf(
                    profile.voidSendCharges()
            );
        }

        if (key.equals("void_send_last_recharge")) {
            return String.valueOf(
                    profile.voidSendLastRechargeAt()
            );
        }

        if (key.equals("void_daily_effect")) {
            String effect = profile.voidDailyEffect();

            return effect == null ? "" : effect;
        }

        if (key.equals("void_daily_effect_assigned")) {
            return String.valueOf(
                    profile.voidDailyEffectAssignedAt()
            );
        }

        return null;
    }

    private BloodlineType findBloodline(String input) {
        String normalized = normalize(input);

        for (BloodlineType type : BloodlineType.values()) {
            if (normalize(type.name()).equals(normalized)) {
                return type;
            }
        }

        return null;
    }

    private String normalize(String input) {
        return input
                .replace("-", "")
                .replace("_", "")
                .replace(" ", "")
                .toLowerCase(Locale.ROOT);
    }

    private String formatBloodline(BloodlineType type) {
        if (type == null) {
            return "None";
        }

        String name = type.name()
                .toLowerCase(Locale.ROOT)
                .replace("_", " ");

        String[] words = name.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            if (!result.isEmpty()) {
                result.append(" ");
            }

            result.append(
                    Character.toUpperCase(word.charAt(0))
            );

            if (word.length() > 1) {
                result.append(word.substring(1));
            }
        }

        return result.toString();
    }
}