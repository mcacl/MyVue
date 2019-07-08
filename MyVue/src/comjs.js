var comjs = {
    tdata: [
        {a: 1, b: 2, c: 3, d: 4},
        {a: 11, b: 12, c: 13, d: 14},
        {a: 21, b: 22, c: 23, d: 24},
        {a: 31, b: 32, c: 33, d: 34},
        {a: 41, b: 42, c: 43, d: 44},
        {a: 51, b: 52, c: 53, d: 54}
    ],
    //设置cookie
    setcookie: function (name, value, time, path) {
        time = !!time ? time : 'd3';
        let strsec = comjs.gettimems(time);
        let exp = new Date();
        exp.setTime(exp.getTime() + strsec * 1);
        document.cookie = name + "=" + encodeURI(value) + ";expires=" + exp.toGMTString() + ";path=/" + (!!path ? path : "");
    },
    //读取cookies
    getcookie: function (name) {
        let reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        let arr = document.cookie.match(reg);
        if (!!arr)
            return decodeURI(arr[2]);
        else
            return null;
    },
    //删除cookies
    delcookie: function (name) {
        let exp = new Date();
        exp.setTime(exp.getTime() - 1);
        let cval = comjs.getcookie(name);
        if (cval != null)
            document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    },
    //取得指定时间的毫秒数 str ：s10->10s m10->10min h10->10H d10->10day
    gettimems: function (str) {
        let str1 = str.substring(1, str.length) * 1;
        let str2 = str.substring(0, 1);
        if (str2 == "s") {
            return str1 * 1000;
        }
        else if (str2 == "m") {
            return str1 * 60 * 1000;
        }
        else if (str2 == "h") {
            return str1 * 60 * 60 * 1000;
        }
        else if (str2 == "d") {
            return str1 * 24 * 60 * 60 * 1000;
        } else {
            return 0;
        }
    }
}
export default comjs;