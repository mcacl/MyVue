var comjs = {
    /**
     * 设置cookie
     *time 3s:秒 3m:3分 3h:3时 3d:3天
     */
    comsetcookie: function (name, value, time, path) {
        time = !!time ? time : 'd3';
        let strsec = comjs.comgettimems(time);
        let exp = new Date();
        exp.setTime(exp.getTime() + strsec * 1);
        document.cookie = name + "=" + encodeURI(value) + ";expires=" + exp.toGMTString() + ";path=/" + (!!path ? path : "");
    },
    //读取cookies
    comgetcookie: function (name) {
        let reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        let arr = document.cookie.match(reg);
        if (!!arr)
            return decodeURI(arr[2]);
        else
            return null;
    },
    //删除cookies
    comdelcookie: function (name) {
        let exp = new Date();
        exp.setTime(exp.getTime() - 1);
        let cval = comjs.comgetcookie(name);
        if (cval != null)
            document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    },
    //取得指定时间的毫秒数 str ：s10->10s m10->10min h10->10H d10->10day
    comgettimems: function (str) {
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
    },
    //对象数组搜索对象或字段 objarr:obj数组 key:唯一标识字段 keyval:值 dgfield:递归字段 无值代表单层查找 targetfield:对象字段 为空时返回整个对象
    comfindobjvaldg: function (objarr, key, keyval, dgfield, targetfield) {
        if (objarr instanceof Array) {
            let resobj;
            for (let index in objarr) {
                if (objarr[index][key] == keyval) {
                    if (!!targetfield) {
                        resobj = objarr[index][targetfield];
                    } else {
                        resobj = objarr[index];
                    }
                } else {
                    if (!!dgfield && objarr[index][dgfield].length > 0) {
                        resobj = comjs.comfindobjvaldg(objarr[index][dgfield], key, keyval, dgfield, targetfield);
                    }
                }
                if (!!resobj) {
                    break;
                }
            }
            return resobj;
        }
    },
    /**
     * 查找单层树数据的节点
     * @param nodedata 全部树数据
     * @param nodefiled 要查找的节点字段
     * @param nodekey 节点值
     * @returns {Array} 节点数据
     */
    comfindobjnode: function (nodedata, nodefiled, nodekey) {
        let resarr = nodedata.filter(function (item) {
            return item[nodefiled] == nodekey;
        });
        return resarr;
    },
    /**
     * 深度对象拷贝
     * @param obj 对象
     * @returns {any}
     */
    comcopy: function (obj) {
        let res = JSON.stringify(obj);
        return JSON.parse(res);
    }
}
export default comjs;