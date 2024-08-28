Before updating, please **back-up** your world. This is a beta version and 
may contain some instability. Greatly appreciate any bug reports on the 
[Github](https://github.com/ChefMooon/frights-delight/issues), I'll be 
actively watching the issues page to resolve any bugs as soon as possible.
This mod is compatible with Minecraft 1.20-1.20.1 and Farmer's Delight Forge,
NeoForge, and Fabric
([details](https://github.com/ChefMooon/frights-delight/wiki#compatible-versions)).

***

Minecraft 1.20.1 **Forge/NeoForge** Initial Release! 
See [Current Features](https://github.com/ChefMooon/frights-delight/wiki/Current-Features).

## Fabric

### Added

- Soul Berry Bush Natural Spawning
- Configuration
- Some food items are now compostable
- Villager and Wandering Trader Trades
- Recipe Viewer Integrations
    - Just Enough Items, Just Enough Effect Descriptions
    - EMI, EMIffect
- WTHIT/WAILA Integration
    - Soul and Wither Berry Bushes
        - Growth Progress
        - Growth Requirement
        - Transform Requirement (Soul Berry Only)
            - Only visible at max age
    - Punch Bowls
        - Servings
- Food Item Tooltip Effect Chance added (configurable)
    - Item's now show the chance the effect will be applied upon consumption
- Added Fright’s Delight Items/Blocks tags
    - Minecraft
        - minecraft:sword_efficient, minecraft:mineable/axe, minecraft:fall_damage_resetting
    - Create: Craft’s and Additions
        - plant_foods
- Added uk_ua translation (Thank you unroman!)

### Changed

- Punch Bowl’s drops changed loot table (can be adjusted with datapacks)
- Soul Berry Loot Table adjusted (more rare)
- Effects Updated
    - Overlay’s Added to all Effects
        - These are applied over the food bar while the effect is active
        - They can be individually enabled/disabled in the configuration
        - Farmer’s Delight overlays will always display if present
    - Undead Hunger
        - Removed Zombie Reinforcement effect
    - Slime Walk
        - New custom subtitle
- Effect durations, and the chance to be applied has been adjusted on most items. Now following a set of rules, detailed changes here.
- Soul and Wither Berry Bush
    - When using Bone Meal the light requirement is ignored, however the block requirement is still needed
    - Checks for growCondition on place instead of first random tick
    - Wither Berry bush will only display smoke if required brightness and growCondition are met, previously only used the growCondition
- Updated zh_cn translation (Thank you QiuShui!)

### Fixed

- Cookies now consumed “fast” matches other cookies

[Detailed Changelog](https://github.com/ChefMooon/frights-delight/wiki/Detailed-Changelog)