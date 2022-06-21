# ComposeDaily——002

## 可组合函数
Jetpack Compose中是不需要XML文件来声明界面元素的，那我们怎么声明界面元素呢，答案就在可组合函数。
> Jetpack Compose 是围绕可组合函数构建的。这些函数让您可以通过描述应用程序的外观和提供数据依赖项来以编程方式定义应用程序的 UI，而不是专注于 UI 的构建过程（初始化元素、将其附加到父级等）。要创建可组合函数，只需 @Composable在函数名称中添加注释即可。

别忘了上节我们学到的setContent()方法中的入参，就是一个@Composable函数。
```kotlin
public fun ComponentActivity.setContent(
    parent: CompositionContext? = null,
    content: @Composable () -> Unit
) {}
```
理论上你把任何一个函数使用@Composable修饰，都可以传入到setContent()方法中，不过要想正确地显示UI，还是要使用到Jetpack Compose中正确的UI组件，这个我们后面会聊到。

现在让我们回到示例程序中，来观察示例程序中是否都是可组合函数，当然这里代码做了简化：

```kotlin
@Composable
fun ComposeDailyTheme() {}

@Composable
fun Surface() {}

@Composable
fun Greeting(name: String) {
}

@Composable
fun Text() {}
```
好了，示例已经很明显了，就不再一一列举了，就像Kotlin 协程中的suspend 函数一样，被可组合函数调用的函数也要使用@Composable修饰，除了SDK 源码甚至连我们自己的Greeting() 方法也是
对了，对于可组合函数与一般函数不同的是，函数名首字母大写

## 预览
也许你早就注意到了在示例代码中除了@Composable， 还有一个@Preview(showBackground = true)
嗯，考虑到目前还在整个学习过程中非常初级的阶段，关于可组合函数我们就先聊到这里，后面我们依然会再进行分析，下面让我们
