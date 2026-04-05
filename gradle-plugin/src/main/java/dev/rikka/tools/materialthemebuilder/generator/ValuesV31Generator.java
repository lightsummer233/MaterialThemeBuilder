package dev.rikka.tools.materialthemebuilder.generator;

import com.google.common.base.CaseFormat;
import dev.rikka.tools.materialthemebuilder.MaterialTheme;
import dev.rikka.tools.materialthemebuilder.MaterialThemeBuilderExtension;
import dev.rikka.tools.materialthemebuilder.Util;
import hct.Hct;

import java.io.File;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class ValuesV31Generator extends ValuesGenerator {

    private final MaterialThemeBuilderExtension extension;

    public ValuesV31Generator(File file, MaterialThemeBuilderExtension extension) {
        super(file);
        this.extension = extension;
    }

    @Override
    protected void onGenerate() {
        extension.getThemes().forEach(this::writeTheme);
    }

    private void writeStylesForTheme(
            String nameLowerUnderScore,
            String nameUpperCamel,
            String lightThemeNameFormat, String parentLightThemeName,
            String darkThemeNameFormat, String parentDarkThemeName) {

        String s = """
                <item name="palettePrimary100">@android:color/system_accent1_0</item>
                <item name="palettePrimary99">@android:color/system_accent1_10</item>
                <item name="palettePrimary95">@android:color/system_accent1_50</item>
                <item name="palettePrimary90">@android:color/system_accent1_100</item>
                <item name="palettePrimary80">@android:color/system_accent1_200</item>
                <item name="palettePrimary70">@android:color/system_accent1_300</item>
                <item name="palettePrimary60">@android:color/system_accent1_400</item>
                <item name="palettePrimary50">@android:color/system_accent1_500</item>
                <item name="palettePrimary40">@android:color/system_accent1_600</item>
                <item name="palettePrimary30">@android:color/system_accent1_700</item>
                <item name="palettePrimary20">@android:color/system_accent1_800</item>
                <item name="palettePrimary10">@android:color/system_accent1_900</item>
                <item name="palettePrimary0">@android:color/system_accent1_1000</item>
                <item name="paletteSecondary100">@android:color/system_accent2_0</item>
                <item name="paletteSecondary99">@android:color/system_accent2_10</item>
                <item name="paletteSecondary95">@android:color/system_accent2_50</item>
                <item name="paletteSecondary90">@android:color/system_accent2_100</item>
                <item name="paletteSecondary80">@android:color/system_accent2_200</item>
                <item name="paletteSecondary70">@android:color/system_accent2_300</item>
                <item name="paletteSecondary60">@android:color/system_accent2_400</item>
                <item name="paletteSecondary50">@android:color/system_accent2_500</item>
                <item name="paletteSecondary40">@android:color/system_accent2_600</item>
                <item name="paletteSecondary30">@android:color/system_accent2_700</item>
                <item name="paletteSecondary20">@android:color/system_accent2_800</item>
                <item name="paletteSecondary10">@android:color/system_accent2_900</item>
                <item name="paletteSecondary0">@android:color/system_accent2_1000</item>
                <item name="paletteTertiary100">@android:color/system_accent3_0</item>
                <item name="paletteTertiary99">@android:color/system_accent3_10</item>
                <item name="paletteTertiary95">@android:color/system_accent3_50</item>
                <item name="paletteTertiary90">@android:color/system_accent3_100</item>
                <item name="paletteTertiary80">@android:color/system_accent3_200</item>
                <item name="paletteTertiary70">@android:color/system_accent3_300</item>
                <item name="paletteTertiary60">@android:color/system_accent3_400</item>
                <item name="paletteTertiary50">@android:color/system_accent3_500</item>
                <item name="paletteTertiary40">@android:color/system_accent3_600</item>
                <item name="paletteTertiary30">@android:color/system_accent3_700</item>
                <item name="paletteTertiary20">@android:color/system_accent3_800</item>
                <item name="paletteTertiary10">@android:color/system_accent3_900</item>
                <item name="paletteTertiary0">@android:color/system_accent3_1000</item>
                <item name="paletteNeutral100">@android:color/system_neutral1_0</item>
                <item name="paletteNeutral99">@android:color/system_neutral1_10</item>
                <item name="paletteNeutral95">@android:color/system_neutral1_50</item>
                <item name="paletteNeutral90">@android:color/system_neutral1_100</item>
                <item name="paletteNeutral80">@android:color/system_neutral1_200</item>
                <item name="paletteNeutral70">@android:color/system_neutral1_300</item>
                <item name="paletteNeutral60">@android:color/system_neutral1_400</item>
                <item name="paletteNeutral50">@android:color/system_neutral1_500</item>
                <item name="paletteNeutral40">@android:color/system_neutral1_600</item>
                <item name="paletteNeutral30">@android:color/system_neutral1_700</item>
                <item name="paletteNeutral20">@android:color/system_neutral1_800</item>
                <item name="paletteNeutral10">@android:color/system_neutral1_900</item>
                <item name="paletteNeutral0">@android:color/system_neutral1_1000</item>
                <item name="paletteNeutralVariant100">@android:color/system_neutral2_0</item>
                <item name="paletteNeutralVariant99">@android:color/system_neutral2_10</item>
                <item name="paletteNeutralVariant95">@android:color/system_neutral2_50</item>
                <item name="paletteNeutralVariant90">@android:color/system_neutral2_100</item>
                <item name="paletteNeutralVariant80">@android:color/system_neutral2_200</item>
                <item name="paletteNeutralVariant70">@android:color/system_neutral2_300</item>
                <item name="paletteNeutralVariant60">@android:color/system_neutral2_400</item>
                <item name="paletteNeutralVariant50">@android:color/system_neutral2_500</item>
                <item name="paletteNeutralVariant40">@android:color/system_neutral2_600</item>
                <item name="paletteNeutralVariant30">@android:color/system_neutral2_700</item>
                <item name="paletteNeutralVariant20">@android:color/system_neutral2_800</item>
                <item name="paletteNeutralVariant10">@android:color/system_neutral2_900</item>
                <item name="paletteNeutralVariant0">@android:color/system_neutral2_1000</item>
                """;

        beginStyle(String.format(lightThemeNameFormat, nameUpperCamel), parentLightThemeName);
        print("""
                <item name="colorPrimary">@color/m3_sys_color_dynamic_light_primary</item>
                <item name="colorOnPrimary">@color/m3_sys_color_dynamic_light_on_primary</item>
                <item name="colorPrimaryInverse">@color/m3_sys_color_dynamic_light_inverse_primary</item>
                <item name="colorPrimaryContainer">@color/m3_sys_color_dynamic_light_primary_container</item>
                <item name="colorOnPrimaryContainer">@color/m3_sys_color_dynamic_light_on_primary_container</item>
                <item name="colorPrimaryFixed">@color/m3_sys_color_dynamic_primary_fixed</item>
                <item name="colorPrimaryFixedDim">@color/m3_sys_color_dynamic_primary_fixed_dim</item>
                <item name="colorOnPrimaryFixed">@color/m3_sys_color_dynamic_on_primary_fixed</item>
                <item name="colorOnPrimaryFixedVariant">@color/m3_sys_color_dynamic_on_primary_fixed_variant</item>
                <item name="colorSecondary">@color/m3_sys_color_dynamic_light_secondary</item>
                <item name="colorOnSecondary">@color/m3_sys_color_dynamic_light_on_secondary</item>
                <item name="colorSecondaryContainer">@color/m3_sys_color_dynamic_light_secondary_container</item>
                <item name="colorOnSecondaryContainer">@color/m3_sys_color_dynamic_light_on_secondary_container</item>
                <item name="colorSecondaryFixed">@color/m3_sys_color_dynamic_secondary_fixed</item>
                <item name="colorSecondaryFixedDim">@color/m3_sys_color_dynamic_secondary_fixed_dim</item>
                <item name="colorOnSecondaryFixed">@color/m3_sys_color_dynamic_on_secondary_fixed</item>
                <item name="colorOnSecondaryFixedVariant">@color/m3_sys_color_dynamic_on_secondary_fixed_variant</item>
                <item name="colorTertiary">@color/m3_sys_color_dynamic_light_tertiary</item>
                <item name="colorOnTertiary">@color/m3_sys_color_dynamic_light_on_tertiary</item>
                <item name="colorTertiaryContainer">@color/m3_sys_color_dynamic_light_tertiary_container</item>
                <item name="colorOnTertiaryContainer">@color/m3_sys_color_dynamic_light_on_tertiary_container</item>
                <item name="colorTertiaryFixed">@color/m3_sys_color_dynamic_tertiary_fixed</item>
                <item name="colorTertiaryFixedDim">@color/m3_sys_color_dynamic_tertiary_fixed_dim</item>
                <item name="colorOnTertiaryFixed">@color/m3_sys_color_dynamic_on_tertiary_fixed</item>
                <item name="colorOnTertiaryFixedVariant">@color/m3_sys_color_dynamic_on_tertiary_fixed_variant</item>
                <item name="android:colorBackground">@color/m3_sys_color_dynamic_light_background</item>
                <item name="colorOnBackground">@color/m3_sys_color_dynamic_light_on_background</item>
                <item name="colorSurface">@color/m3_sys_color_dynamic_light_surface</item>
                <item name="colorOnSurface">@color/m3_sys_color_dynamic_light_on_surface</item>
                <item name="colorSurfaceVariant">@color/m3_sys_color_dynamic_light_surface_variant</item>
                <item name="colorOnSurfaceVariant">@color/m3_sys_color_dynamic_light_on_surface_variant</item>
                <item name="colorSurfaceInverse">@color/m3_sys_color_dynamic_light_inverse_surface</item>
                <item name="colorOnSurfaceInverse">@color/m3_sys_color_dynamic_light_inverse_on_surface</item>
                <item name="colorSurfaceBright">@color/m3_sys_color_dynamic_light_surface_bright</item>
                <item name="colorSurfaceDim">@color/m3_sys_color_dynamic_light_surface_dim</item>
                <item name="colorSurfaceContainer">@color/m3_sys_color_dynamic_light_surface_container</item>
                <item name="colorSurfaceContainerLow">@color/m3_sys_color_dynamic_light_surface_container_low</item>
                <item name="colorSurfaceContainerHigh">@color/m3_sys_color_dynamic_light_surface_container_high</item>
                <item name="colorSurfaceContainerLowest">@color/m3_sys_color_dynamic_light_surface_container_lowest</item>
                <item name="colorSurfaceContainerHighest">@color/m3_sys_color_dynamic_light_surface_container_highest</item>
                <item name="colorOutline">@color/m3_sys_color_dynamic_light_outline</item>
                <item name="colorOutlineVariant">@color/m3_sys_color_dynamic_light_outline_variant</item>\
                <item name="colorError">@color/m3_sys_color_light_error</item>
                <item name="colorOnError">@color/m3_sys_color_light_on_error</item>
                <item name="colorErrorContainer">@color/m3_sys_color_light_error_container</item>
                <item name="colorOnErrorContainer">@color/m3_sys_color_light_on_error_container</item>
                <item name="android:textColorPrimary">@color/m3_dynamic_default_color_primary_text</item>
                <item name="android:textColorPrimaryInverse">@color/m3_dynamic_dark_default_color_primary_text</item>
                <item name="android:textColorSecondary">@color/m3_dynamic_default_color_secondary_text</item>
                <item name="android:textColorSecondaryInverse">@color/m3_dynamic_dark_default_color_secondary_text</item>
                <item name="android:textColorTertiary">@color/m3_dynamic_default_color_secondary_text</item>
                <item name="android:textColorTertiaryInverse">@color/m3_dynamic_dark_default_color_secondary_text</item>
                <item name="android:textColorPrimaryDisableOnly">@color/m3_dynamic_primary_text_disable_only</item>
                <item name="android:textColorPrimaryInverseDisableOnly">@color/m3_dynamic_dark_primary_text_disable_only</item>
                <item name="android:textColorHint">@color/m3_dynamic_hint_foreground</item>
                <item name="android:textColorHintInverse">@color/m3_dynamic_dark_hint_foreground</item>
                <item name="android:textColorHighlight">@color/m3_dynamic_highlighted_text</item>
                <item name="android:textColorHighlightInverse">@color/m3_dynamic_dark_highlighted_text</item>
                <item name="android:textColorAlertDialogListItem">@color/m3_dynamic_default_color_primary_text</item>
                """);

        // Extended colors
        for (MaterialThemeBuilderExtension.ExtendedColor extendedColor : extension.getExtendedColors()) {
            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                styleColorRef(
                        color.getAttributeName(extendedColor.getNameForAttribute()),
                        color.getFileName(nameLowerUnderScore, true, extendedColor.getNameForAttribute()));
            }
            style("harmonize" + extendedColor.getNameForAttribute(), Boolean.toString(extendedColor.isHarmonize()));
        }
        if (extension.isGeneratePalette()) {
            print(s);
        }
        if (extension.isGenerateTextColors()) {
            textColorStyles();
        }
        endStyle();

        beginStyle(String.format(darkThemeNameFormat, nameUpperCamel), parentDarkThemeName);
        print("""
                <item name="colorPrimary">@color/m3_sys_color_dynamic_dark_primary</item>
                <item name="colorOnPrimary">@color/m3_sys_color_dynamic_dark_on_primary</item>
                <item name="colorPrimaryInverse">@color/m3_sys_color_dynamic_dark_inverse_primary</item>
                <item name="colorPrimaryContainer">@color/m3_sys_color_dynamic_dark_primary_container</item>
                <item name="colorOnPrimaryContainer">@color/m3_sys_color_dynamic_dark_on_primary_container</item>
                <item name="colorPrimaryFixed">@color/m3_sys_color_dynamic_primary_fixed</item>
                <item name="colorPrimaryFixedDim">@color/m3_sys_color_dynamic_primary_fixed_dim</item>
                <item name="colorOnPrimaryFixed">@color/m3_sys_color_dynamic_on_primary_fixed</item>
                <item name="colorOnPrimaryFixedVariant">@color/m3_sys_color_dynamic_on_primary_fixed_variant</item>
                <item name="colorSecondary">@color/m3_sys_color_dynamic_dark_secondary</item>
                <item name="colorOnSecondary">@color/m3_sys_color_dynamic_dark_on_secondary</item>
                <item name="colorSecondaryContainer">@color/m3_sys_color_dynamic_dark_secondary_container</item>
                <item name="colorOnSecondaryContainer">@color/m3_sys_color_dynamic_dark_on_secondary_container</item>
                <item name="colorSecondaryFixed">@color/m3_sys_color_dynamic_secondary_fixed</item>
                <item name="colorSecondaryFixedDim">@color/m3_sys_color_dynamic_secondary_fixed_dim</item>
                <item name="colorOnSecondaryFixed">@color/m3_sys_color_dynamic_on_secondary_fixed</item>
                <item name="colorOnSecondaryFixedVariant">@color/m3_sys_color_dynamic_on_secondary_fixed_variant</item>
                <item name="colorTertiary">@color/m3_sys_color_dynamic_dark_tertiary</item>
                <item name="colorOnTertiary">@color/m3_sys_color_dynamic_dark_on_tertiary</item>
                <item name="colorTertiaryContainer">@color/m3_sys_color_dynamic_dark_tertiary_container</item>
                <item name="colorOnTertiaryContainer">@color/m3_sys_color_dynamic_dark_on_tertiary_container</item>
                <item name="colorTertiaryFixed">@color/m3_sys_color_dynamic_tertiary_fixed</item>
                <item name="colorTertiaryFixedDim">@color/m3_sys_color_dynamic_tertiary_fixed_dim</item>
                <item name="colorOnTertiaryFixed">@color/m3_sys_color_dynamic_on_tertiary_fixed</item>
                <item name="colorOnTertiaryFixedVariant">@color/m3_sys_color_dynamic_on_tertiary_fixed_variant</item>
                <item name="android:colorBackground">@color/m3_sys_color_dynamic_dark_background</item>
                <item name="colorOnBackground">@color/m3_sys_color_dynamic_dark_on_background</item>
                <item name="colorSurface">@color/m3_sys_color_dynamic_dark_surface</item>
                <item name="colorOnSurface">@color/m3_sys_color_dynamic_dark_on_surface</item>
                <item name="colorSurfaceVariant">@color/m3_sys_color_dynamic_dark_surface_variant</item>
                <item name="colorOnSurfaceVariant">@color/m3_sys_color_dynamic_dark_on_surface_variant</item>
                <item name="colorSurfaceInverse">@color/m3_sys_color_dynamic_dark_inverse_surface</item>
                <item name="colorOnSurfaceInverse">@color/m3_sys_color_dynamic_dark_inverse_on_surface</item>
                <item name="colorSurfaceBright">@color/m3_sys_color_dynamic_dark_surface_bright</item>
                <item name="colorSurfaceDim">@color/m3_sys_color_dynamic_dark_surface_dim</item>
                <item name="colorSurfaceContainer">@color/m3_sys_color_dynamic_dark_surface_container</item>
                <item name="colorSurfaceContainerLow">@color/m3_sys_color_dynamic_dark_surface_container_low</item>
                <item name="colorSurfaceContainerHigh">@color/m3_sys_color_dynamic_dark_surface_container_high</item>
                <item name="colorSurfaceContainerLowest">@color/m3_sys_color_dynamic_dark_surface_container_lowest</item>
                <item name="colorSurfaceContainerHighest">@color/m3_sys_color_dynamic_dark_surface_container_highest</item>
                <item name="colorOutline">@color/m3_sys_color_dynamic_dark_outline</item>
                <item name="colorOutlineVariant">@color/m3_sys_color_dynamic_dark_outline_variant</item>\
                <item name="colorError">@color/m3_sys_color_dark_error</item>
                <item name="colorOnError">@color/m3_sys_color_dark_on_error</item>
                <item name="colorErrorContainer">@color/m3_sys_color_dark_error_container</item>
                <item name="colorOnErrorContainer">@color/m3_sys_color_dark_on_error_container</item>
                <item name="android:textColorPrimary">@color/m3_dynamic_dark_default_color_primary_text</item>
                <item name="android:textColorPrimaryInverse">@color/m3_dynamic_default_color_primary_text</item>
                <item name="android:textColorSecondary">@color/m3_dynamic_dark_default_color_secondary_text</item>
                <item name="android:textColorSecondaryInverse">@color/m3_dynamic_default_color_secondary_text</item>
                <item name="android:textColorTertiary">@color/m3_dynamic_dark_default_color_secondary_text</item>
                <item name="android:textColorTertiaryInverse">@color/m3_dynamic_default_color_secondary_text</item>
                <item name="android:textColorPrimaryDisableOnly">@color/m3_dynamic_dark_primary_text_disable_only</item>
                <item name="android:textColorPrimaryInverseDisableOnly">@color/m3_dynamic_primary_text_disable_only</item>
                <item name="android:textColorHint">@color/m3_dynamic_dark_hint_foreground</item>
                <item name="android:textColorHintInverse">@color/m3_dynamic_hint_foreground</item>
                <item name="android:textColorHighlight">@color/m3_dynamic_dark_highlighted_text</item>
                <item name="android:textColorHighlightInverse">@color/m3_dynamic_highlighted_text</item>
                <item name="android:textColorAlertDialogListItem">@color/m3_dynamic_dark_default_color_primary_text</item>
                """);

        // Extended colors
        for (MaterialThemeBuilderExtension.ExtendedColor extendedColor : extension.getExtendedColors()) {
            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                styleColorRef(
                        color.getAttributeName(extendedColor.getNameForAttribute()),
                        color.getFileName(nameLowerUnderScore, false, extendedColor.getNameForAttribute()));
            }
            style("harmonize" + extendedColor.getNameForAttribute(), Boolean.toString(extendedColor.isHarmonize()));
        }
        if (extension.isGeneratePalette()) {
            print(s);
        }
        if (extension.isGenerateTextColors()) {
            textColorStyles();
        }
        endStyle();
    }

    private void writeExtendedColors(
            MaterialThemeBuilderExtension.ExtendedColor extendedColor,
            String nameLowerUnderScore) {

        if (!extendedColor.isHarmonize()) {
            return;
        }
        var extendedColorName = extendedColor.getNameForAttribute();
        var extendedColorInt = Integer.parseInt(extendedColor.getColor().replaceFirst("#", ""), 16);

        {
            var hctColor = Hct.fromInt(extendedColorInt);

            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                hctColor.setTone(color.getToneLight());
                color(hctColor.toInt(), color.getFileName(nameLowerUnderScore, true, extendedColorName));
            }
        }

        {
            var hctColor = Hct.fromInt(extendedColorInt);

            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                hctColor.setTone(color.getToneDark());
                color(hctColor.toInt(), color.getFileName(nameLowerUnderScore, false, extendedColorName));
            }
        }
    }

    private void writeTheme(MaterialThemeBuilderExtension.Theme theme) {
        if (!theme.isDynamicColors()) {
            return;
        }

        var name = Util.capitalize(Objects.requireNonNull(theme.getName(), "Name must not be null")
                .replaceAll("-", "_"));
        var lightThemeNameFormat = Optional.ofNullable(theme.getLightThemeFormat()).orElse("");
        var darkThemeNameFormat = Optional.ofNullable(theme.getDarkThemeFormat()).orElse("");
        var parentLightThemeName = Optional.ofNullable(theme.getLightThemeParent()).orElse("");
        var parentDarkThemeName = Optional.ofNullable(theme.getDarkThemeParent()).orElse("");

        String nameUpperCamel;
        String nameLowerUnderScore;
        var nameIsUnderScore = name.contains("_");
        if (nameIsUnderScore) {
            name = name.toLowerCase(Locale.ROOT);
            nameUpperCamel = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
            nameLowerUnderScore = name;
        } else {
            nameUpperCamel = name;
            nameLowerUnderScore = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
        }

        for (MaterialThemeBuilderExtension.ExtendedColor extendedColor : extension.getExtendedColors()) {
            writeExtendedColors(extendedColor, nameLowerUnderScore);
        }
        writeStylesForTheme(nameLowerUnderScore, nameUpperCamel, lightThemeNameFormat, parentLightThemeName, darkThemeNameFormat, parentDarkThemeName);
    }
}
