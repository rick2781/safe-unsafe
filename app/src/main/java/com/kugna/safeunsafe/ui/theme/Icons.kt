package com.kugna.safeunsafe.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp


// Got this icons from https://composeicons.com/
object CustomIcons {
    public val Brightness_alert: ImageVector
        get() {
            if (_Brightness_alert != null) {
                return _Brightness_alert!!
            }
            _Brightness_alert = ImageVector.Builder(
                name = "Brightness_alert",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(480f, 680f)
                    quadToRelative(17f, 0f, 28.5f, -11.5f)
                    reflectiveQuadTo(520f, 640f)
                    reflectiveQuadToRelative(-11.5f, -28.5f)
                    reflectiveQuadTo(480f, 600f)
                    reflectiveQuadToRelative(-28.5f, 11.5f)
                    reflectiveQuadTo(440f, 640f)
                    reflectiveQuadToRelative(11.5f, 28.5f)
                    reflectiveQuadTo(480f, 680f)
                    moveToRelative(-40f, -160f)
                    horizontalLineToRelative(80f)
                    verticalLineToRelative(-240f)
                    horizontalLineToRelative(-80f)
                    close()
                    moveToRelative(40f, 412f)
                    lineTo(346f, 800f)
                    horizontalLineTo(160f)
                    verticalLineToRelative(-186f)
                    lineTo(28f, 480f)
                    lineToRelative(132f, -134f)
                    verticalLineToRelative(-186f)
                    horizontalLineToRelative(186f)
                    lineToRelative(134f, -132f)
                    lineToRelative(134f, 132f)
                    horizontalLineToRelative(186f)
                    verticalLineToRelative(186f)
                    lineToRelative(132f, 134f)
                    lineToRelative(-132f, 134f)
                    verticalLineToRelative(186f)
                    horizontalLineTo(614f)
                    close()
                    moveToRelative(0f, -112f)
                    lineToRelative(100f, -100f)
                    horizontalLineToRelative(140f)
                    verticalLineToRelative(-140f)
                    lineToRelative(100f, -100f)
                    lineToRelative(-100f, -100f)
                    verticalLineToRelative(-140f)
                    horizontalLineTo(580f)
                    lineTo(480f, 140f)
                    lineTo(380f, 240f)
                    horizontalLineTo(240f)
                    verticalLineToRelative(140f)
                    lineTo(140f, 480f)
                    lineToRelative(100f, 100f)
                    verticalLineToRelative(140f)
                    horizontalLineToRelative(140f)
                    close()
                    moveToRelative(0f, -340f)
                }
            }.build()
            return _Brightness_alert!!
        }

    private var _Brightness_alert: ImageVector? = null

    public val Timer_play: ImageVector
        get() {
            if (_Timer_play != null) {
                return _Timer_play!!
            }
            _Timer_play = ImageVector.Builder(
                name = "Timer_play",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(360f, 120f)
                    verticalLineToRelative(-80f)
                    horizontalLineToRelative(240f)
                    verticalLineToRelative(80f)
                    close()
                    moveTo(480f, 880f)
                    quadToRelative(-74f, 0f, -139.5f, -28.5f)
                    reflectiveQuadTo(226f, 774f)
                    reflectiveQuadToRelative(-77.5f, -114.5f)
                    reflectiveQuadTo(120f, 520f)
                    reflectiveQuadToRelative(28.5f, -139.5f)
                    reflectiveQuadTo(226f, 266f)
                    reflectiveQuadToRelative(114.5f, -77.5f)
                    reflectiveQuadTo(480f, 160f)
                    quadToRelative(62f, 0f, 119f, 20f)
                    reflectiveQuadToRelative(107f, 58f)
                    lineToRelative(56f, -56f)
                    lineToRelative(56f, 56f)
                    lineToRelative(-56f, 56f)
                    quadToRelative(38f, 50f, 58f, 107f)
                    reflectiveQuadToRelative(20f, 119f)
                    quadToRelative(0f, 74f, -28.5f, 139.5f)
                    reflectiveQuadTo(734f, 774f)
                    reflectiveQuadToRelative(-114.5f, 77.5f)
                    reflectiveQuadTo(480f, 880f)
                    moveToRelative(0f, -80f)
                    quadToRelative(116f, 0f, 198f, -82f)
                    reflectiveQuadToRelative(82f, -198f)
                    reflectiveQuadToRelative(-82f, -198f)
                    reflectiveQuadToRelative(-198f, -82f)
                    reflectiveQuadToRelative(-198f, 82f)
                    reflectiveQuadToRelative(-82f, 198f)
                    reflectiveQuadToRelative(82f, 198f)
                    reflectiveQuadToRelative(198f, 82f)
                    moveToRelative(-80f, -120f)
                    lineToRelative(240f, -160f)
                    lineToRelative(-240f, -160f)
                    close()
                }
            }.build()
            return _Timer_play!!
        }

    private var _Timer_play: ImageVector? = null

    public val Speed: ImageVector
        get() {
            if (_Speed != null) {
                return _Speed!!
            }
            _Speed = ImageVector.Builder(
                name = "Speed",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(418f, 620f)
                    quadToRelative(24f, 24f, 62f, 23.5f)
                    reflectiveQuadToRelative(56f, -27.5f)
                    lineToRelative(224f, -336f)
                    lineToRelative(-336f, 224f)
                    quadToRelative(-27f, 18f, -28.5f, 55f)
                    reflectiveQuadToRelative(22.5f, 61f)
                    moveToRelative(62f, -460f)
                    quadToRelative(59f, 0f, 113.5f, 16.5f)
                    reflectiveQuadTo(696f, 226f)
                    lineToRelative(-76f, 48f)
                    quadToRelative(-33f, -17f, -68.5f, -25.5f)
                    reflectiveQuadTo(480f, 240f)
                    quadToRelative(-133f, 0f, -226.5f, 93.5f)
                    reflectiveQuadTo(160f, 560f)
                    quadToRelative(0f, 42f, 11.5f, 83f)
                    reflectiveQuadToRelative(32.5f, 77f)
                    horizontalLineToRelative(552f)
                    quadToRelative(23f, -38f, 33.5f, -79f)
                    reflectiveQuadToRelative(10.5f, -85f)
                    quadToRelative(0f, -36f, -8.5f, -70f)
                    reflectiveQuadTo(766f, 420f)
                    lineToRelative(48f, -76f)
                    quadToRelative(30f, 47f, 47.5f, 100f)
                    reflectiveQuadTo(880f, 554f)
                    reflectiveQuadToRelative(-13f, 109f)
                    reflectiveQuadToRelative(-41f, 99f)
                    quadToRelative(-11f, 18f, -30f, 28f)
                    reflectiveQuadToRelative(-40f, 10f)
                    horizontalLineTo(204f)
                    quadToRelative(-21f, 0f, -40f, -10f)
                    reflectiveQuadToRelative(-30f, -28f)
                    quadToRelative(-26f, -45f, -40f, -95.5f)
                    reflectiveQuadTo(80f, 560f)
                    quadToRelative(0f, -83f, 31.5f, -155.5f)
                    reflectiveQuadToRelative(86f, -127f)
                    reflectiveQuadToRelative(127.5f, -86f)
                    reflectiveQuadTo(480f, 160f)
                    moveToRelative(7f, 313f)
                }
            }.build()
            return _Speed!!
        }

    private var _Speed: ImageVector? = null

    public val Car_crash: ImageVector
        get() {
            if (_Car_crash != null) {
                return _Car_crash!!
            }
            _Car_crash = ImageVector.Builder(
                name = "Car_crash",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(160f, 720f)
                    verticalLineToRelative(-200f)
                    close()
                    moveTo(80f, 520f)
                    lineToRelative(84f, -240f)
                    quadToRelative(6f, -18f, 21.5f, -29f)
                    reflectiveQuadToRelative(34.5f, -11f)
                    horizontalLineToRelative(183f)
                    quadToRelative(-3f, 20f, -3f, 40f)
                    reflectiveQuadToRelative(3f, 40f)
                    horizontalLineTo(234f)
                    lineToRelative(-42f, 120f)
                    horizontalLineToRelative(259f)
                    quadToRelative(17f, 24f, 38f, 44.5f)
                    reflectiveQuadToRelative(47f, 35.5f)
                    horizontalLineTo(160f)
                    verticalLineToRelative(200f)
                    horizontalLineToRelative(560f)
                    verticalLineToRelative(-163f)
                    quadToRelative(21f, -3f, 41f, -9f)
                    reflectiveQuadToRelative(39f, -15f)
                    verticalLineToRelative(307f)
                    quadToRelative(0f, 17f, -11.5f, 28.5f)
                    reflectiveQuadTo(760f, 880f)
                    horizontalLineToRelative(-40f)
                    quadToRelative(-17f, 0f, -28.5f, -11.5f)
                    reflectiveQuadTo(680f, 840f)
                    verticalLineToRelative(-40f)
                    horizontalLineTo(200f)
                    verticalLineToRelative(40f)
                    quadToRelative(0f, 17f, -11.5f, 28.5f)
                    reflectiveQuadTo(160f, 880f)
                    horizontalLineToRelative(-40f)
                    quadToRelative(-17f, 0f, -28.5f, -11.5f)
                    reflectiveQuadTo(80f, 840f)
                    close()
                    moveToRelative(540f, 160f)
                    quadToRelative(25f, 0f, 42.5f, -17.5f)
                    reflectiveQuadTo(680f, 620f)
                    reflectiveQuadToRelative(-17.5f, -42.5f)
                    reflectiveQuadTo(620f, 560f)
                    reflectiveQuadToRelative(-42.5f, 17.5f)
                    reflectiveQuadTo(560f, 620f)
                    reflectiveQuadToRelative(17.5f, 42.5f)
                    reflectiveQuadTo(620f, 680f)
                    moveToRelative(-360f, 0f)
                    quadToRelative(25f, 0f, 42.5f, -17.5f)
                    reflectiveQuadTo(320f, 620f)
                    reflectiveQuadToRelative(-17.5f, -42.5f)
                    reflectiveQuadTo(260f, 560f)
                    reflectiveQuadToRelative(-42.5f, 17.5f)
                    reflectiveQuadTo(200f, 620f)
                    reflectiveQuadToRelative(17.5f, 42.5f)
                    reflectiveQuadTo(260f, 680f)
                    moveToRelative(420f, -200f)
                    quadToRelative(-83f, 0f, -141.5f, -58.5f)
                    reflectiveQuadTo(480f, 280f)
                    quadToRelative(0f, -82f, 58f, -141f)
                    reflectiveQuadToRelative(142f, -59f)
                    quadToRelative(83f, 0f, 141.5f, 58.5f)
                    reflectiveQuadTo(880f, 280f)
                    reflectiveQuadToRelative(-58.5f, 141.5f)
                    reflectiveQuadTo(680f, 480f)
                    moveToRelative(-20f, -160f)
                    horizontalLineToRelative(40f)
                    verticalLineToRelative(-160f)
                    horizontalLineToRelative(-40f)
                    close()
                    moveToRelative(20f, 80f)
                    quadToRelative(8f, 0f, 14f, -6f)
                    reflectiveQuadToRelative(6f, -14f)
                    reflectiveQuadToRelative(-6f, -14f)
                    reflectiveQuadToRelative(-14f, -6f)
                    reflectiveQuadToRelative(-14f, 6f)
                    reflectiveQuadToRelative(-6f, 14f)
                    reflectiveQuadToRelative(6f, 14f)
                    reflectiveQuadToRelative(14f, 6f)
                }
            }.build()
            return _Car_crash!!
        }

    private var _Car_crash: ImageVector? = null

    public val Phonelink_ring: ImageVector
        get() {
            if (_Phonelink_ring != null) {
                return _Phonelink_ring!!
            }
            _Phonelink_ring = ImageVector.Builder(
                name = "Phonelink_ring",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(734f, 594f)
                    lineToRelative(-58f, -58f)
                    quadToRelative(12f, -11f, 18.5f, -25.5f)
                    reflectiveQuadTo(701f, 480f)
                    reflectiveQuadToRelative(-6.5f, -30.5f)
                    reflectiveQuadTo(676f, 424f)
                    lineToRelative(58f, -58f)
                    quadToRelative(23f, 23f, 35f, 52.5f)
                    reflectiveQuadToRelative(12f, 61.5f)
                    reflectiveQuadToRelative(-12f, 61.5f)
                    reflectiveQuadToRelative(-35f, 52.5f)
                    moveToRelative(98f, 98f)
                    lineToRelative(-56f, -56f)
                    quadToRelative(31f, -31f, 48f, -71f)
                    reflectiveQuadToRelative(17f, -85f)
                    reflectiveQuadToRelative(-17f, -85f)
                    reflectiveQuadToRelative(-48f, -71f)
                    lineToRelative(56f, -56f)
                    quadToRelative(43f, 42f, 66f, 97f)
                    reflectiveQuadToRelative(23f, 115f)
                    reflectiveQuadToRelative(-23f, 115f)
                    reflectiveQuadToRelative(-66f, 97f)
                    moveTo(280f, 920f)
                    quadToRelative(-33f, 0f, -56.5f, -23.5f)
                    reflectiveQuadTo(200f, 840f)
                    verticalLineToRelative(-720f)
                    quadToRelative(0f, -33f, 23.5f, -56.5f)
                    reflectiveQuadTo(280f, 40f)
                    horizontalLineToRelative(400f)
                    quadToRelative(33f, 0f, 56.5f, 23.5f)
                    reflectiveQuadTo(760f, 120f)
                    verticalLineToRelative(160f)
                    horizontalLineToRelative(-80f)
                    verticalLineToRelative(-40f)
                    horizontalLineTo(280f)
                    verticalLineToRelative(480f)
                    horizontalLineToRelative(400f)
                    verticalLineToRelative(-40f)
                    horizontalLineToRelative(80f)
                    verticalLineToRelative(160f)
                    quadToRelative(0f, 33f, -23.5f, 56.5f)
                    reflectiveQuadTo(680f, 920f)
                    close()
                    moveToRelative(0f, -120f)
                    verticalLineToRelative(40f)
                    horizontalLineToRelative(400f)
                    verticalLineToRelative(-40f)
                    close()
                    moveToRelative(0f, -640f)
                    horizontalLineToRelative(400f)
                    verticalLineToRelative(-40f)
                    horizontalLineTo(280f)
                    close()
                    moveToRelative(0f, 0f)
                    verticalLineToRelative(-40f)
                    close()
                    moveToRelative(0f, 640f)
                    verticalLineToRelative(40f)
                    close()
                }
            }.build()
            return _Phonelink_ring!!
        }

    private var _Phonelink_ring: ImageVector? = null

    public val Directions: ImageVector
        get() {
            if (_Directions != null) {
                return _Directions!!
            }
            _Directions = ImageVector.Builder(
                name = "Directions",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 960f,
                viewportHeight = 960f
            ).apply {
                path(
                    fill = SolidColor(Color.Black),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(320f, 600f)
                    horizontalLineToRelative(80f)
                    verticalLineToRelative(-120f)
                    horizontalLineToRelative(140f)
                    verticalLineToRelative(100f)
                    lineToRelative(140f, -140f)
                    lineToRelative(-140f, -140f)
                    verticalLineToRelative(100f)
                    horizontalLineTo(360f)
                    quadToRelative(-17f, 0f, -28.5f, 11.5f)
                    reflectiveQuadTo(320f, 440f)
                    close()
                    moveTo(480f, 880f)
                    quadToRelative(-15f, 0f, -29.5f, -6f)
                    reflectiveQuadTo(424f, 856f)
                    lineTo(104f, 536f)
                    quadToRelative(-12f, -12f, -18f, -26.5f)
                    reflectiveQuadTo(80f, 480f)
                    reflectiveQuadToRelative(6f, -29.5f)
                    reflectiveQuadToRelative(18f, -26.5f)
                    lineToRelative(320f, -320f)
                    quadToRelative(12f, -12f, 26.5f, -18f)
                    reflectiveQuadToRelative(29.5f, -6f)
                    reflectiveQuadToRelative(29.5f, 6f)
                    reflectiveQuadToRelative(26.5f, 18f)
                    lineToRelative(320f, 320f)
                    quadToRelative(12f, 12f, 18f, 26.5f)
                    reflectiveQuadToRelative(6f, 29.5f)
                    reflectiveQuadToRelative(-6f, 29.5f)
                    reflectiveQuadToRelative(-18f, 26.5f)
                    lineTo(536f, 856f)
                    quadToRelative(-12f, 12f, -26.5f, 18f)
                    reflectiveQuadTo(480f, 880f)
                    moveTo(320f, 640f)
                    lineToRelative(160f, 160f)
                    lineToRelative(320f, -320f)
                    lineToRelative(-320f, -320f)
                    lineToRelative(-320f, 320f)
                    close()
                    moveToRelative(160f, -160f)
                }
            }.build()
            return _Directions!!
        }

    private var _Directions: ImageVector? = null
}
