package me.shedaniel.fiber2cloth.api;

import io.github.fablabsmc.fablabs.api.fiber.v1.FiberId;
import io.github.fablabsmc.fablabs.api.fiber.v1.schema.type.derived.ConfigTypes;
import io.github.fablabsmc.fablabs.api.fiber.v1.tree.ConfigAttribute;
import me.shedaniel.fiber2cloth.impl.Fiber2ClothImpl;
import me.shedaniel.fiber2cloth.impl.GroupDisplay;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.stream.IntStream;

public final class ClothAttributes {
    private ClothAttributes() {
    }

    /* aesthetics */
    public static final FiberId DEFAULT_BACKGROUND = id("background");
    public static final FiberId CATEGORY_BACKGROUND = id("category_background");

    /* display options */
    public static final FiberId EXCLUDED = id("excluded");
    public static final FiberId GROUP_DISPLAY = id("group_display");

    /* descriptions */
    public static final FiberId PREFIX_TEXT = id("prefix_text");
    public static final FiberId TOOLTIP = id("tooltip");


    public static ConfigAttribute<String> defaultBackground(String backgroundLocation) {
        return ConfigAttribute.create(DEFAULT_BACKGROUND, Fiber2ClothImpl.IDENTIFIER_TYPE.getSerializedType(), backgroundLocation);
    }

    public static ConfigAttribute<String> defaultBackground(Identifier backgroundLocation) {
        return ConfigAttribute.create(DEFAULT_BACKGROUND, Fiber2ClothImpl.IDENTIFIER_TYPE, backgroundLocation);
    }

    public static ConfigAttribute<String> categoryBackground(String backgroundLocation) {
        return ConfigAttribute.create(CATEGORY_BACKGROUND, Fiber2ClothImpl.IDENTIFIER_TYPE.getSerializedType(), backgroundLocation);
    }

    public static ConfigAttribute<String> categoryBackground(Identifier backgroundLocation) {
        return ConfigAttribute.create(CATEGORY_BACKGROUND, Fiber2ClothImpl.IDENTIFIER_TYPE, backgroundLocation);
    }


    public static ConfigAttribute<Boolean> excluded() {
        return ConfigAttribute.create(EXCLUDED, ConfigTypes.BOOLEAN, true);
    }

    public static ConfigAttribute<String> collapsible(boolean startExpanded) {
        return ConfigAttribute.create(GROUP_DISPLAY, GroupDisplay.TYPE, startExpanded ? GroupDisplay.COLLAPSIBLE_EXPANDED : GroupDisplay.COLLAPSIBLE);
    }

    public static ConfigAttribute<String> transitive() {
        return ConfigAttribute.create(GROUP_DISPLAY, GroupDisplay.TYPE, GroupDisplay.TRANSITIVE);
    }


    public static ConfigAttribute<String> prefixText(String prefixKey) {
        return ConfigAttribute.create(PREFIX_TEXT, ConfigTypes.STRING, prefixKey);
    }

    public static ConfigAttribute<List<String>> tooltip(String baseKey, int numberOfLines) {
        return tooltip(IntStream.range(1, numberOfLines + 1).mapToObj(i -> baseKey + i).toArray(String[]::new));
    }

    public static ConfigAttribute<List<String>> tooltip(String... tooltipKeys) {
        return ConfigAttribute.create(TOOLTIP, ConfigTypes.makeArray(ConfigTypes.STRING), tooltipKeys);
    }


    private static FiberId id(String name) {
        return new FiberId("fiber2cloth", name);
    }

}
