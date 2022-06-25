# ComposeDaily——004

## UI元素的更新
在过去的View系统中，我们习惯了这样更新View:
```kotlin
val tvTest = findViewById<TextView>(R.id.tvTest)
tvTest.text = "测试文案"
```
不过在JetPack Compose中却不会有这样的代码，在了解JetPack Compose如何更新UI之前，我们先分析下UI界面

## 界面UI元素的静态与动态
![image](https://github.com/seanutf/ComposeDaily/blob/day004/img/day_004_taobao_test.jpeg)
上面是一个淘宝的不同界面，无论界面的业务逻辑是怎样的，界面中的元素始终能分为两大类：
1界面整个生命周期中始终不需要变化的UI元素：比如，客服按钮、返回按钮
2界面整个生命周期中根据业务场景变化的UI元素：比如，商品头图、商品标题、价格等

如果在View系统中基于XML来实现这些UI元素的摆放，很可能因为那些动态变化的UI元素而导致整个界面的重绘(想想经典的View的三大方法吧),
影响整个界面的响应性能。而在诸如Flutter、Jetpack Compose这些声明式UI框架中在设计中就引入了这种区分不变和变化的思想。
将UI元素分为可变和不可变两大阵营。

## 可变状态与不可变状态
如果你了解过Flutter，就会想起，Flutter的组件分为无状态组件和有状态组件。Jetpack Compose也类似，不过它不是在组件上做状态区分，而是在数据上。
在Jetpack Compose中所有的组件默认都是与状态无关的，而想要组件有状态，需要你去主动声明一个与状态相关的数据，再把数据与相应的组件绑定即可。

```kotlin
@Composable
fun Greeting(name: String) {
    //Text(text = "Hello $name!")
    BasicText(
        text = "Helo $name!",
    )
}
```
上面这个Greeting组件就是无状态的，初始状态我们设置什么字符串Text就会始终显示什么字符串，不会动态改变。
如果想让它能够动态改变，我们需要使用remember相关api来将数据与状态组合，并设置给组件
现在我们继续写一段具有交互的示例代码来实现动态改变数据
```kotlin
@Composable
fun Test() {
    var count by remember { mutableStateOf(0) }
    ClickCounter(count) {
        count += 1
    }
}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("I've been clicked $clicks times")
    }
}
```
界面上展示一个按钮，每点击一次按钮就在按钮上显示这是第几次被点击， 这样我们就能写出一个非常简单的具有交互的示例代码。

在这段代码中，我们可以看到count被定义成一个可变状态的变量，并且提供了默认值0，通过remember api 会在SDK的底层将状态值缓存下来。

这样我们在每一次点击时都可以将点击次数更新并缓存下来更新显示。

但是remember缓存的数据在界面配置改变后会被丢弃。所以，如果想在配置更改时(如旋转界面)仍然保留状态，可以使用rememberSaveable。

数据和状态的改变引发组件的显示更新，而组件更新的机制就是重组

## 重组

> 在命令式界面模型中，如需更改某个微件，您可以在该微件上调用 setter 以更改其内部状态。在 Compose 中，您可以使用新数据再次调用可组合函数。这样做会导致函数进行重组 -- 系统会根据需要使用新数据重新绘制函数发出的微件。Compose 框架可以智能地仅重组已更改的组件。

我们可以通过对一次点击的debug，来简单的窥探下重组机制：在一次点击中，调用了两次组件，并且发生了数据的变化，后续我们也将分析为何会触发两次
![image](https://github.com/seanutf/ComposeDaily/blob/day004/img/iShot_2022-06-25_21.31.46.png)
![image](https://github.com/seanutf/ComposeDaily/blob/day004/img/iShot_2022-06-25_21.32.25.png)


## Jetpack Compose中的include: 状态提升

