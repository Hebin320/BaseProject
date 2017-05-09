

## 应用插件库说明

* cropImage_library  —— 图片裁切的插件

* multipleimageselect —— 从文件夹中选取图片的插件

* rollviewpager —— 自动无限轮播的Viewpager，支持小圆点、提示文字，支持修改圆点尺寸、间距、背景、背景透明度等

* superrecyclerview —— 支持下拉刷新、上拉加载更多的Recyclerview。其中包含了一个加载动画的插件库；支持自定义上拉、下拉样式、支持修   改没有更多的样式

* takephoto —— 图片选择库，支持单选、多选、相机拍照、主要解决了机型适配问题

* zxing —— 扫描二维码的插件，支持自定义扫描界面，支持从图片识别二维码，支持返回扫描（拍照）的照片

* tbs_sdk_thirdapp —— QQ浏览器 X5Webview

* marqueeview —— 垂直翻页公告插件  GitHub地址：https://github.com/sfsheng0322/MarqueeView

## base 功能说明 （基础类的包）

* BaseActivity —— 基础的Activity，可以在其中添加统计代码、设置状态栏、验证token是否有效等

* BaseFile —— SharedPreferences保存数据的类

* MyApplication —— 实现OKGo的配置、x5Webview的配置等；

## custom 功能说明 （自定义View的包）

* glide —— 第三方图片加载插件的功能延伸，实现加载成圆角图片（GlideRoundTransform）或者圆形图片（GlideCircleTransform）

* preview —— 选择多图之后，对多图进行预览，可删除 ，ZoomImageView实现可缩放的ImageView

* MyCardView —— 实现低版本去掉阴影效果，5.0以上版本设置阴影效果，解决低版本有边距的问题

* RemainingEditText —— 动态监听EditText的输入字数，显示出剩余可输入字数

* RippleView —— 实现点击波纹效果的Relatelayout

* SlidingLayout —— 侧滑关闭Activity

* MyTablayout —— 重写TabLayout，可设置图片（在文字的上下左右各个方向），可设置字体颜色（选中与未选中）、背景颜色、字体大小

* DisableScrollViewpager —— 不可左右滑动的Viewpager

* X5WebView —— QQ浏览器

* encapsulation 功能说明（一些功能方法的集合工具类）

* EditTextTool —— EditText的工具类，显示、隐藏输入内容；动态改变输入框底部的线条；为文本添加下划线；根据内容是否为空显示或隐藏删除   按钮；
* 改变部分字体颜色；发送验证码倒计时；隐藏手机号

* PermissionTool —— 动态申请权限的工具类（用于Android6.0以上）

* RecyclerViewTool —— 设置RecyclerView是线性还是格子类型

* CropPicTool —— 图片选择的工具类（相册选择、照相机选择、是否裁切）

* ViewpagerPoint —— 为Viewpager添加小圆点

* ViewpagerTool —— Viewpager的工具类，切换Viewpager，切换RadioButton

## minterface接口类 

## minterface接口类

*  base包内的接口为实现MVP的基础回调接口

## model 功能说明（业务逻辑处理工具类）

* OkgoGetModel —— 网络请求框架为OKGo；GET请求的基础类，其他网络请求可直接调用

* OkgoPostModel —— 网络请求框架为OKGo；POST请求的基础类，其他网络请求可直接调用

## ui 功能说明（视图）

* BannerLocalAdapter —— 加载本地图片到Viewpager中，可自动切换，无限轮播

* BannerUrlAdapter —— 加载网络图片到Viewpager中，可自动切换，无限轮播

* FragmentViewpagerAdapter —— Viewpager 加载Fragment

* ViewpagerImgeViewAdapter —— Viewpager 加载ImgeView ，不可自动轮播

## utils 功能说明（工具类）

* ActivityManager —— Activity管理工具类，可用于结束指定的Activity

* DensityUtil  —— 单位换算工具类

* DialogUtil —— 加载对话框的工具类

* ImageUtil —— 图片工具类；加载网络（圆形、圆角、正常）图片、压缩图片

* LostFocusUtil —— 触碰父布局隐藏输入法 ；有列表的界面，使列表失去焦点

* ScaleAnimatorUtil —— 收藏与取消收藏的动画效果

* SingletonUtil —— 泛型实现单例

* SystemBarTintManager —— 改变状态栏颜色的工具类

* ToastUtil —— toast的工具类 ；居中显示，解决版本适配问题

* WindowsUtil —— 关于屏幕的工具类，获取屏幕宽、高、设置全屏等

