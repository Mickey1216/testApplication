//let t = document.getElementById("test").value = 'aaa';
function testIntent() {
    var url = 'http://120.78.198.170:3300/test'
    document.getElementById("txt2").value = '进入fetch';
    fetch(url).then((res)=>{
        // document.getElementById("txt2").value = '进入网络请求01'+(res);
        // console.log('返回结果',res.json())
        return res.text();
    },(err)=>{
        document.getElementById("txt2").value = '进入网络请求1'+(err);
    }).then((res)=>{
        console.log('数据',res)
        document.getElementById("txt2").value = '网络请求成功：'+(res);
    })
}
function testIntent2(){
    document.getElementById("txt3").value = '进入ajax';

    var xhr = new XMLHttpRequest();
    var url = 'http://120.78.198.170:3300/test'
    xhr.open("GET", url, true);
    xhr.setRequestHeader("content-Type", "gext/plain;charset=UTF-8");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && (xhr.status === 200 || xhr.status === 0)) {
            //         console.log('请求到的数据',xhr.responseText)
            document.getElementById("txt3").value = 'ajax网络请求成功:'+(xhr.responseText);
        }else{
        }
    }
    xhr.send(null);
}