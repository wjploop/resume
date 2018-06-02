$(function () {

    //监听文件选择,得到图片的base64字符串,这里不能选择太大的文件,否则直接崩溃
    //若是可以,在选择
    $("body").on("change","#upload_avatar", listeningFileInput);

    $("#upload_btn").on("click",uploadAvatar);


});

//图片的base64格式的字符窜
let base64Str;

function uploadAvatar() {
    let fd = new FormData();
    fd.append("file", $("#file")[0].files[0]);
    //
    // if(!base64Str) {
    //     alert("请先选择图片");
    //     return;
    // }
    $.ajax({
        url:"avatar",
        type:"post",
        processData:false,
        contentType:false,
        dataType:"json",
        data:fd,
        success: function (result) {
            console.log("result:"+result.data)
            //todo 不应仅限于跳转resume_id=1页面
            window.location.href = "detail.html?resume_id=1";
        },
        error:function () {
            alert("上传头像失败");
        }
    })
}
function listeningFileInput() {
    let reader = new FileReader();
    reader.onload=function () {
        let arrayBuffer = this.result,
            array = new Uint8Array(arrayBuffer),
            binaryString = String.fromCharCode.apply(null, array);
        base64Str = base64encode(binaryString);
        console.log(base64Str);
    }
    reader.readAsArrayBuffer(this.files[0]);
}


var base64EncodeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
var base64DecodeChars = new Array(
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
    52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
    -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
    15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
    -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
    41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1);
function base64encode(str) {
    var out, i, len;
    var c1, c2, c3;

    len = str.length;
    i = 0;
    out = "";
    while(i < len) {
        c1 = str.charCodeAt(i++) & 0xff;
        if(i == len)
        {
            out += base64EncodeChars.charAt(c1 >> 2);
            out += base64EncodeChars.charAt((c1 & 0x3) << 4);
            out += "==";
            break;
        }
        c2 = str.charCodeAt(i++);
        if(i == len)
        {
            out += base64EncodeChars.charAt(c1 >> 2);
            out += base64EncodeChars.charAt(((c1 & 0x3)<< 4) | ((c2 & 0xF0) >> 4));
            out += base64EncodeChars.charAt((c2 & 0xF) << 2);
            out += "=";
            break;
        }
        c3 = str.charCodeAt(i++);
        out += base64EncodeChars.charAt(c1 >> 2);
        out += base64EncodeChars.charAt(((c1 & 0x3)<< 4) | ((c2 & 0xF0) >> 4));
        out += base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >>6));
        out += base64EncodeChars.charAt(c3 & 0x3F);
    }
    return out;
}