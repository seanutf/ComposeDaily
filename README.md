# ComposeDaily——001

## 声明式UI

## Compose中的Activity

Compose 中的Activity 基类直接就是ComponentActivity, 而非FragmentActivity 以及AppCompatActivity
【需要补充关系图片】
## Compose中的 setContent()
Compose中的 setContent()方法与一般Activity的setContentView()不同但近似，实际上setContent()方法就是ComponentActivity
的一个扩展函数
```kotlin
public fun ComponentActivity.setContent(
    parent: CompositionContext? = null,
    content: @Composable () -> Unit
) {
    val existingComposeView = window.decorView
        .findViewById<ViewGroup>(android.R.id.content)
        .getChildAt(0) as? ComposeView

    if (existingComposeView != null) with(existingComposeView) {
        setParentCompositionContext(parent)
        setContent(content)
    } else ComposeView(this).apply {
        // Set content and parent **before** setContentView
        // to have ComposeView create the composition on attach
        setParentCompositionContext(parent)
        setContent(content)
        // Set the view tree owners before setting the content view so that the inflation process
        // and attach listeners will see them already present
        setOwners()
        setContentView(this, DefaultActivityContentLayoutParams)
    }
}
```
这里可以看到通过DecorView查找ContentView，进而判断ContentView是否为一个ComposeView，一个ComposeView又继承自
AbstractComposeView，AbstractComposeView又是一个ViewGroup，所以肯定的是ComposeView是一个ViewGroup。
```kotlin
class ComposeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {}

abstract class AbstractComposeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {}
```
而调用ComposeView的setContent(content)方法，却并不是类似之前的addView()方法的封装，而是直接对内部content对象的设置
