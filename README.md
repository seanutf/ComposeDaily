# ComposeDaily——008

## 图片：Image(1)

之前的示例代码中尽量避免使用图片相关的，一个是作为基础元素组件，以Text为例就可以，二来也是想专门的讲下图片

在Jetpack Compose中展示图片使用Image组件。而Image组件对应的有三个实现方式：
```kotlin
@Composable
fun Image(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }

    // Explicitly use a simple Layout implementation here as Spacer squashes any non fixed
    // constraint with zero
    Layout(
        {},
        modifier.then(semantics).clipToBounds().paint(
            painter,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter
        )
    ) { _, constraints ->
        layout(constraints.minWidth, constraints.minHeight) {}
    }
}
```
指定一个自定义的画笔进行绘制的图片

```kotlin
@Composable
fun Image(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) = Image(
    painter = rememberVectorPainter(imageVector),
    contentDescription = contentDescription,
    modifier = modifier,
    alignment = alignment,
    contentScale = contentScale,
    alpha = alpha,
    colorFilter = colorFilter
)
```

传入一个自定义的矢量图进行绘制的图片，内部调用的还是自定义画笔实现

```kotlin
@Composable
fun Image(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    filterQuality: FilterQuality = DefaultFilterQuality
) {
    val bitmapPainter = remember(bitmap) { BitmapPainter(bitmap, filterQuality = filterQuality) }
    Image(
        painter = bitmapPainter,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )
}
```

传入一个自定义的ImageBitmap进行绘制的图片，内部调用的也是自定义画笔实现

这个ImageBitmap就是Compose中的Bitmap，Compose中提供了两者互转的方法：

```kotlin
fun ImageBitmap.asAndroidBitmap(): Bitmap =
    when (this) {
        is AndroidImageBitmap -> bitmap
        else -> throw UnsupportedOperationException("Unable to obtain android.graphics.Bitmap")
    }


fun Bitmap.asImageBitmap(): ImageBitmap = AndroidImageBitmap(this)
```

在这一小节的示例代码中我们展示了ImageVector如何使用的。
