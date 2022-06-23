# ComposeDaily——003

## Text
现在在setContent()方法里和@Preview修饰的DefaultPreview()方法里，只有一个Greeting()方法，这个方法也只调用了Text()方法，
但就是这个Text()方法，却能为我们呈现文本，就像示例代码中的一样，我们传入一些自定义的字符串给Text()方法中的text参数，
我们就能在预览界面中看到我们传入的字符串，同时我们可以尝试修改传入的字符串，预览界面同样会很快随着变化。

现在让我们换个词汇描述Text(), 不在叫它方法，在Jetpack Compose中，我们叫它组件，或者Widget,如果你熟悉Flutter，这里就和Flutter相像，
同样地，Text组件中的text参数我们也换成属性这个叫法，之后我们还会学习Jetpack Compose中其他组件与布局。

现在我们点进去Text组件，进入它的源码中，我们会看到它有很多的属性供我们设置：
```kotlin
@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {}
```
有文案、字色、字号、字重还可以设置自定义字体等等。这些后续我们会有专门的文字专题来介绍如何自定义文字，
如果你着急实现你想要的需求可以先自行摸索。

在源码中我们还看到，在Text组件中，最终调用了BasicText组件。
> Compose 提供了基础的 BasicText 和 BasicTextField，它们是用于显示文字以及处理用户输入的主要函数。Compose 还提供了更高级的 Text 和 TextField，它们是遵循 Material Design 准则的可组合项。建议在 Android 平台上使用这些构建块，因为它们的外观和样式非常适合 Android 用户，而且还包括可用以简化用户自定义设置的其他选项，无需编写大量代码。

