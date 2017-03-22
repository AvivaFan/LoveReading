package com.android.reading.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/21 19:54.
 * LoveReading.
 */

public class UserBean extends BaseAvivaResBean implements Parcelable {

    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public static class User implements Parcelable {
        private int id;
        private String name;
        private String email;
        private String phone;
        private String password;
        private String real_name;
        private String device;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeString(this.email);
            dest.writeString(this.phone);
            dest.writeString(this.password);
            dest.writeString(this.real_name);
            dest.writeString(this.device);
        }

        public User() {
        }

        protected User(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.email = in.readString();
            this.phone = in.readString();
            this.password = in.readString();
            this.real_name = in.readString();
            this.device = in.readString();
        }

        public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
            @Override
            public User createFromParcel(Parcel source) {
                return new User(source);
            }

            @Override
            public User[] newArray(int size) {
                return new User[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    public UserBean() {
    }

    protected UserBean(Parcel in) {
        this.data = in.readParcelable(User.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };
}
