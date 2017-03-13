package com.android.reading.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/7 3:51.
 * LoveReading.
 */

public class JokeBean implements Parcelable {

    /**
     * reason : success
     * result : [{"content":"去面馆吃面，当面端到我面前的时候，我惊呆了！鸡肉，猪肉，鱼肉，蔬菜，应有尽有，高端大气上档次！弄的我半天都没敢下筷子，心里不断嘀咕：\u201c我特么兜里就8块钱，能够吗？\u201d于是我大喊：\u201c老板！过来一下！\u201d老板小跑过来问道：\u201c顾客怎么了！\u201d我指着面说道：\u201c你看看这碗面...\u201d老板看了一眼，马上把新来的小工叫了出来骂道：\u201c都Tm说你多少回了！不要老把垃圾桶放汤桶旁边，又Tm盛错了吧！\u201d","hashId":"C94ED0C86B95DAC390AC76EEE3200902","unixtime":"1419965825"},{"content":"　　结婚后就没买过烟 　　老婆每月就给10块，都用来买套套，（老婆不想要小孩儿） 　　没办法，只能跟哥们儿噌烟了 　　噌了一个月，大家都把烟戒了，，，，，，","hashId":"9F7F3120978D550EDDEE6AF47E478BB2","unixtime":"1419965986"},{"content":"魔王拿着儿子的照片，问孙悟空:知道这照片是谁么。孙悟空看了看说不知道。牛魔王回头就把铁扇公主拎起来说:火眼金睛都没看出来那是我儿子，你他妈还好说你在外面没有人","hashId":"07BC0666BF2DB573FF94C266CD9F1712","unixtime":"1419967024"},{"content":"中学时，我们班主任经常扒后门玻璃监视我们，可恐怖了！有次我豁出去和他对视，他也盯着我，足有半分钟。\u201c你赢了。\u201d他嘟哝了一句走了。放学后我被留下抄书，嘀咕着，我要当校长，第一个开除你。他听见了，说，你也当不了校长。现在我真当了校长，却再也找不到他这样负责的老师\u2026\u2026","hashId":"51F77B3AEE0779F378533FC907CC49C4","unixtime":"1419968226"},{"content":"　　甲：今天在车里差点睡着了。 　　已：睡着了就睡着了多大点事啊。 　　甲：我他妈是司机！！！","hashId":"44D34AE5DBB0A04CF733A1E4881B86EF","unixtime":"1419969514"},{"content":"侄子病了，我想给他倒水吃药，但是热水瓶的水太热了，我怕烫到他，就找了两个杯子，把水来回倒，侄子在边上看了几分钟，就问：叔叔，你想好了吗？到底用哪个杯子？","hashId":"70D66B2D8EED5F7AEAA7CBB7A9581992","unixtime":"1419970623"},{"content":"我在办公楼下面开了家奶茶店，只有5套桌椅，为了防止有人长时间蹭Wifi，就加了密，Wifi名称叫你愿意做我女朋友吗，密码是woyuanyi。每天下午3点，一位应该是在楼上工作的女神级美女都会来喝杯咖啡小憩一会儿，安静的看会儿手机。一天我经过她身边有意无意间发现她Wifi信号满格，我该做点什么吗？","hashId":"A34AF3A08748DA379BB30F1B6675D692","unixtime":"1419971825"},{"content":"　　刚看见朋友圈里写：那些年和我一起疯过，笑过，闹过，傻过的你们都去哪儿了？ 　　神回复：带娃儿去了。。。。。。 　　（好心酸的答案）","hashId":"F2AB7B7CE22F5E29C1625C84EF4456D5","unixtime":"1419973103"},{"content":"人与人之间的差距就是--马云在大批量招兵买马，而我却连他招聘的职位都看不懂。这真是个极度悲伤的故事。。。","hashId":"C53BC7C6FE59F15FE51E33F711237E0D","unixtime":"1419974227"},{"content":"今天闺蜜在网上摇到一个水暖工，对方问她\u201c家里冷不冷\u201d，她说\u201c冷\u201d。问她\u201c有多冷\u201d，闺蜜问我怎么回答，我说\u201c告诉他，有时候在屋里冻的都得上外面暖和去\u201d","hashId":"3F76D711ABCC149D54D028108D64D10E","unixtime":"1419974227"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Parcelable {
        /**
         * content : 去面馆吃面，当面端到我面前的时候，我惊呆了！鸡肉，猪肉，鱼肉，蔬菜，应有尽有，高端大气上档次！弄的我半天都没敢下筷子，心里不断嘀咕：“我特么兜里就8块钱，能够吗？”于是我大喊：“老板！过来一下！”老板小跑过来问道：“顾客怎么了！”我指着面说道：“你看看这碗面...”老板看了一眼，马上把新来的小工叫了出来骂道：“都Tm说你多少回了！不要老把垃圾桶放汤桶旁边，又Tm盛错了吧！”
         * hashId : C94ED0C86B95DAC390AC76EEE3200902
         * unixtime : 1419965825
         */

        private String content;
        private String hashId;
        private String unixtime;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.content);
            dest.writeString(this.hashId);
            dest.writeString(this.unixtime);
        }

        public ResultBean() {
        }

        protected ResultBean(Parcel in) {
            this.content = in.readString();
            this.hashId = in.readString();
            this.unixtime = in.readString();
        }

        public static final Parcelable.Creator<ResultBean> CREATOR = new Parcelable.Creator<ResultBean>() {
            @Override
            public ResultBean createFromParcel(Parcel source) {
                return new ResultBean(source);
            }

            @Override
            public ResultBean[] newArray(int size) {
                return new ResultBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reason);
        dest.writeInt(this.error_code);
        dest.writeTypedList(this.result);
    }

    public JokeBean() {
    }

    protected JokeBean(Parcel in) {
        this.reason = in.readString();
        this.error_code = in.readInt();
        this.result = in.createTypedArrayList(ResultBean.CREATOR);
    }

    public static final Parcelable.Creator<JokeBean> CREATOR = new Parcelable.Creator<JokeBean>() {
        @Override
        public JokeBean createFromParcel(Parcel source) {
            return new JokeBean(source);
        }

        @Override
        public JokeBean[] newArray(int size) {
            return new JokeBean[size];
        }
    };
}
