# 🩸 Bloodline SMP — PlaceholderAPI Expansion

A custom [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) expansion for **Bloodline SMP**.

The expansion exposes Bloodline SMP player data, Bloodline progression, cooldowns, ability states, and dynamic Bloodline information through PlaceholderAPI.

It can be used with plugins such as:

- TAB
- DeluxeMenus
- FancyHolograms
- Scoreboards
- Skript
- Other PlaceholderAPI-compatible plugins

---

## 📋 Requirements

- Minecraft Java Edition
- Paper / Spigot
- Bloodline SMP
- PlaceholderAPI

---

## 📥 Installation

1. Install [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/).
2. Install Bloodline SMP.
3. Place the expansion JAR into:

```text
plugins/PlaceholderAPI/expansions/
```

4. Restart the server or reload PlaceholderAPI:

```text
/papi reload
```

5. Verify that the expansion loaded:

```text
/papi list
```

You should see:

```text
bloodline
```

---

# 🩸 Placeholders

The expansion uses the `bloodline` identifier.

---

## 📋 Basic

| Placeholder | Description |
|---|---|
| `%bloodline_uuid%` | Player's Bloodline profile UUID |
| `%bloodline_active%` | Current active Bloodline |
| `%bloodline_active_name%` | Display name of the active Bloodline |
| `%bloodline_active_level%` | Current level of the active Bloodline |

### Examples

```text
%bloodline_uuid%
%bloodline_active%
%bloodline_active_name%
%bloodline_active_level%
```

---

## 📊 Dynamic Bloodlines

These placeholders work automatically with Bloodline types.

| Placeholder | Description |
|---|---|
| `%bloodline_level_<bloodline>%` | Returns the player's level for a Bloodline |
| `%bloodline_owns_<bloodline>%` | Checks whether the player owns the Bloodline |
| `%bloodline_is_<bloodline>%` | Checks whether the Bloodline is currently active |
| `%bloodline_exists_<bloodline>%` | Checks whether the Bloodline exists |

Replace `<bloodline>` with the Bloodline identifier.

### Examples

```text
%bloodline_level_aqua%
%bloodline_level_spartan%
%bloodline_level_earthian%
%bloodline_level_voider%
%bloodline_level_raiju%
%bloodline_level_hera%
%bloodline_level_otzi%
%bloodline_level_universal%
```

These placeholders are designed to work automatically with every `BloodlineType`, including future Bloodlines.

---

## 📚 Bloodline Discovery

| Placeholder | Description |
|---|---|
| `%bloodline_list%` | Returns the available Bloodline list |
| `%bloodline_count%` | Returns the number of available Bloodlines |

### Examples

```text
%bloodline_list%
%bloodline_count%
```

---

## ⚙️ Progression

| Placeholder | Description |
|---|---|
| `%bloodline_all_base_maxed%` | Checks whether all base Bloodline progression is maxed |
| `%bloodline_fresh_assignment%` | Checks whether the player has a fresh Bloodline assignment |
| `%bloodline_omni_blade_locked%` | Checks whether the Omni Blade is locked |

### Examples

```text
%bloodline_all_base_maxed%
%bloodline_fresh_assignment%
%bloodline_omni_blade_locked%
```

---

## ⏱️ Cooldowns

Cooldown placeholders are dynamically generated.

| Placeholder | Description |
|---|---|
| `%bloodline_cooldown_<name>%` | Returns the cooldown state/value for an ability |
| `%bloodline_cooldown_remaining_<name>%` | Returns the remaining cooldown for an ability |

Replace `<name>` with the appropriate ability/cooldown identifier.

### Examples

```text
%bloodline_cooldown_<name>%
%bloodline_cooldown_remaining_<name>%
```

---

# ⚔️ Spartan

Spartan-specific placeholders.

| Placeholder | Description |
|---|---|
| `%bloodline_spartan_flaming_hands%` | Flaming Hands state |
| `%bloodline_spartan_flaming_hands_until%` | Time until Flaming Hands ends |
| `%bloodline_spartan_flaming_hands_remaining%` | Remaining Flaming Hands time |
| `%bloodline_spartan_cursed%` | Whether the player is currently cursed |
| `%bloodline_spartan_cursed_by%` | Player who applied the curse |
| `%bloodline_spartan_cursed_until%` | Time until the curse ends |
| `%bloodline_spartan_cursed_remaining%` | Remaining curse duration |

### Examples

```text
%bloodline_spartan_flaming_hands%
%bloodline_spartan_flaming_hands_until%
%bloodline_spartan_flaming_hands_remaining%
%bloodline_spartan_cursed%
%bloodline_spartan_cursed_by%
%bloodline_spartan_cursed_until%
%bloodline_spartan_cursed_remaining%
```

---

# 🌌 Voider

Voider-specific placeholders.

| Placeholder | Description |
|---|---|
| `%bloodline_void_send_charges%` | Current Void Send charges |
| `%bloodline_void_send_last_recharge%` | Time of the last Void Send recharge |
| `%bloodline_void_daily_effect%` | Current daily Void effect |
| `%bloodline_void_daily_effect_assigned%` | Whether a daily Void effect has been assigned |

### Examples

```text
%bloodline_void_send_charges%
%bloodline_void_send_last_recharge%
%bloodline_void_daily_effect%
%bloodline_void_daily_effect_assigned%
```

---

# 🔄 Dynamic Bloodline Support

A major feature of this expansion is dynamic Bloodline support.

Instead of hardcoding every Bloodline into the expansion, Bloodline information is retrieved dynamically from Bloodline SMP.

For example:

```text
%bloodline_level_aqua%
```

can retrieve the player's Aqua level.

Likewise:

```text
%bloodline_level_raiju%
```

can retrieve the player's Raiju level.

The system is designed to work automatically with every `BloodlineType`, including future Bloodlines.

This means new Bloodlines do not necessarily require new hardcoded PlaceholderAPI entries.

---

# 🧪 Testing

You can test placeholders directly from Minecraft.

### Active Bloodline

```text
/papi parse me %bloodline_active_name%
```

### Active Bloodline Level

```text
/papi parse me %bloodline_active_level%
```

### Bloodline Level

```text
/papi parse me %bloodline_level_aqua%
```

### Bloodline Ownership

```text
/papi parse me %bloodline_owns_aqua%
```

### Active Bloodline Check

```text
/papi parse me %bloodline_is_aqua%
```

### Bloodline Count

```text
/papi parse me %bloodline_count%
```

---

# 🎨 Example — FancyHolograms

```yaml
text:
  - <gray>Bloodline</gray> <dark_gray>»</dark_gray> <red>%bloodline_active_name%</red>
  - <gray>Bloodline Level</gray> <dark_gray>»</dark_gray> <white>%bloodline_active_level%</white>
```

Example result:

```text
Bloodline » Aqua
Bloodline Level » 4
```

---

# 📋 Example — DeluxeMenus

```yaml
lore:
  - "&7Bloodline: &f%bloodline_active_name%"
  - "&7Level: &f%bloodline_active_level%"
  - "&7Aqua Level: &b%bloodline_level_aqua%"
```

---

# 📊 Example — TAB

```text
%bloodline_active_name%
```

```text
%bloodline_active_level%
```

---

# 📜 Example — Bloodline Progression Menu

```text
Aqua: %bloodline_level_aqua%
Spartan: %bloodline_level_spartan%
Earthian: %bloodline_level_earthian%
Voider: %bloodline_level_voider%
Raiju: %bloodline_level_raiju%
Hera: %bloodline_level_hera%
Otzi: %bloodline_level_otzi%
Universal: %bloodline_level_universal%
```

---

# ⚠️ Compatibility

This expansion is designed specifically for Bloodline SMP.

Compatibility depends on the Bloodline SMP API and `PlayerProfile` implementation available in the installed Bloodline SMP version.

If Bloodline SMP changes its internal API, some placeholders may require an update.

---

# 🛠️ Development

This project uses Maven.

The Bloodline SMP server JAR is used as the compile-time dependency.

Example:

```xml
<dependency>
    <groupId>dev.whiskers</groupId>
    <artifactId>bloodline-smp</artifactId>
    <version>2.9.8</version>
    <scope>system</scope>
    <systemPath>
        ${project.basedir}/libs/BloodLine Server-2.9.8.jar
    </systemPath>
</dependency>
```

The required Bloodline SMP JAR must be available locally when compiling.

---

# 📁 Project Structure

```text
Expansion-Bloodline/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── ...
```

---

# 🤝 Contributing

Pull requests and improvements are welcome.

When adding a new placeholder:

1. Use a clear and descriptive name.
2. Document it in this README.
3. Prefer dynamic Bloodline data where possible.
4. Avoid unnecessary hardcoded Bloodline names.
5. Test the placeholder using `/papi parse`.
6. Make sure existing placeholders continue working.

---

# 🔗 Links

## Bloodline SMP

**Website:**  
https://bloodlinesmp.vercel.app/

**Modrinth:**  
https://modrinth.com/plugin/bloodlinesmp

**GitHub:**  
https://github.com/w4whiskerss/bloodline-smp

## PlaceholderAPI

https://www.spigotmc.org/resources/placeholderapi.6245/

---

# 🩸 Credits

Created for **Bloodline SMP**.

Built using [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/).

Bloodline SMP Plugin made by [W4Whiskers](https://github.com/w4whiskerss)
