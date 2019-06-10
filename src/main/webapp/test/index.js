
let data = [
    {
        value: "这是第一条弹幕",
        speed: 2,
        time: 0,
        color: "red",
        fontSize: 20
    },
    {
        value: "这是第二条弹幕",
        time: 1
    }
];

class Barrage {
    constructor(item, ctx) {
        this.value = item.value; // 弹幕的内容
        this.time = item.time; // 弹幕出现的时间
        this.item = item; // 每一个弹幕的数据对象
        this.ctx = ctx; // 弹幕功能类的执行上下文
    }

    // ********** 以下为新增代码 **********
    init() {
        this.opacity = this.item.opacity || this.ctx.opacity;
        this.color = this.item.color || this.ctx.color;
        this.fontSize = this.item.fontSize || this.ctx.fontSize;
        this.speed = this.item.speed || this.ctx.speed;

        // 求自己的宽度，目的是用来校验当前是否还要继续绘制（边界判断）
        let span = document.createElement("span");

        // 能决定宽度的只有弹幕的内容和文字的大小，和字体，字体默认为微软雅黑，我们就不做设置了
        span.innerText = this.value;
        span.style.font = this.fontSize + 'px "Microsoft YaHei';

        // span 为行内元素，取不到宽度，所以我们通过定位给转换成块级元素
        span.style.position = "absolute";

        document.body.appendChild(span); // 放入页面
        this.width = span.clientWidth; // 记录弹幕的宽度
        document.body.removeChild(span); // 从页面移除

        // 存储弹幕出现的横纵坐标
        this.x = this.ctx.canvas.width;
        this.y = this.ctx.canvas.height*Math.random();

        // 处理弹幕纵向溢出的边界处理
        if (this.y < this.fontSize) {
            this.y = this.fontSize;
        }
        if (this.y > this.ctx.canvas.height - this.fontSize) {
            this.y = this.ctx.canvas.height - this.fontSize;
        }
    }

    render() {
        this.ctx.context.font = this.fontSize + 'px "Microsoft YaHei"';
        this.ctx.context.fillStyle = this.color;
        this.ctx.context.fillText(this.value, this.x, this.y);
    }
    // ********** 以上为新增代码 **********
}

class CanvasBarrage {
    constructor(canvas, video, options = {}) {
        // 如果没有传入 canvas 或者 video 直接跳出
        if (!canvas || !video) return;
        this.canvas = canvas; // 当前的 canvas 元素
        this.video = video; // 当前的 video 元素

        // 设置 canvas 与 video 等高
        this.canvas.width = video.clientWidth;
        this.canvas.height = video.clientHeight;

        // 默认暂停播放，表示不渲染弹幕
        this.isPaused = true;

        // 没传参数的默认值
        let defaultOptions = {
            fontSize: 20,
            color: "gold",
            speed: 2,
            opacity: 0.3,
            data: []
        };

        // 对象的合并，将默认参数对象的属性和传入对象的属性统一放到当前实例上
        Object.assign(this, defaultOptions, options);


        // ********** 以下为新增代码 **********
        // 存放所有弹幕实例，Barrage 是创造每一条弹幕的实例的类
        this.barrages = this.data.map(item => new Barrage(item, this));
        // ********** 以上为新增代码 **********


        // ********** 以下为新增代码 **********
        // Canvas 画布的内容
        this.context = canvas.getContext("2d");

        // 渲染所有的弹幕
        this.render();
        // ********** 以上为新增代码 **********

    }

    // ********** 以下为新增代码 **********
    render() {
        // 渲染整个弹幕
        // 第一次先进行清空操作，执行渲染弹幕，如果没有暂停，继续渲染
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
        // 渲染弹幕
        this.renderBarrage();
        if (this.isPaused == false) {
            // 递归渲染
            requestAnimationFrame(this.render.bind(this));
        }
    }
    // ********** 以上为新增代码 **********



    // ********** 以下为新增代码 **********
    renderBarrage() {
        // 将数组的弹幕一个一个取出，判断时间和视频的时间是否符合，符合就执行渲染此弹幕
        let time = this.video.currentTime;
        this.barrages.forEach(barrage => {
            // 当视频时间大于等于了弹幕设置的时间，那么开始渲染（时间都是以秒为单位）
            if (!barrage.flag && time >= barrage.time) {
                // 初始化弹幕的各个参数，只有在弹幕将要出现的时候再去初始化，节省性能，初始化后再进行绘制
                // 如果没有初始化，先去初始化一下
                if (!barrage.isInited) {
                    // 初始化后下次再渲染就不需要再初始化了，所以创建一个标识 isInited
                    barrage.init();
                    barrage.isInited = true;
                }

                barrage.x -= barrage.speed;
                barrage.render(); // 渲染该条弹幕
                if (barrage.x < barrage.width * -1) {
                    barrage.flag = true; // 是否出去了，出去了，做停止渲染的操作
                }
            }
        });
    }
    // ********** 以上为新增代码 **********


    add(item) {
        this.barrages.push(new Barrage(item, this));
    }


    reset() {
        // 先清空 Canvas 画布
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
        let time = this.video.currentTime;
        // 循环每一条弹幕实例
        this.barrages.forEach(barrage => {
            // 更改已经移出屏幕的弹幕状态
            barrage.flag = false;
            // 当拖动到的时间小于等于当前弹幕时间是，重新初始化弹幕的数据，实现渲染
            if (time <= barrage.time) {
                barrage.isInited = false;
            } else {
                barrage.flag = true; // 否则将弹幕的状态设置为以移出屏幕
            }
        });
    }
    //reset做的事
    //清空 Canvas 画布；
    // 获取当前进度条拖动位置的时间；
    // 循环存储弹幕实例的数组；
    // 将所有弹幕更改为未移出屏幕；
    // 判断拖动时间和每条弹幕的时间；
    // 在当前时间以后的弹幕重新初始化数据；
    // 以前的弹幕更改为已移出屏幕。
    //end


}


const $ = document.querySelector.bind(document);

// 获取 Canvas 元素和 Video 元素
let canvas = $("#canvas");
let video = $("#video");

let canvasBarrage = new CanvasBarrage(canvas, video, {
    data
});

// 添加播放事件
video.addEventListener("play", function() {
    canvasBarrage.isPaused = false;
    canvasBarrage.render();
});


// 添加暂停事件
video.addEventListener("pause", function() {
    canvasBarrage.isPaused = true;
});


video.addEventListener("seeked", function() {
    canvasBarrage.reset();
});

$("#add").addEventListener("click", function() {
    let time = video.currentTime; // 发送弹幕的时间
    let value = $("#text").value; // 发送弹幕的文字
    let color = $("#color").value; // 发送弹幕文字的颜色
    let fontSize = $("#range").value; // 发送弹幕的字体大小
    let sendObj = { time, value, color, fontSize }; //发送弹幕的参数集合
    canvasBarrage.add(sendObj); // 发送弹幕的方法
});

