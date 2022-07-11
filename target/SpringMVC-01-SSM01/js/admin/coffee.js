function add() {

    var coffeetype = $("#Coffeetype").val();
    var tasteId = $("#tasteId").val();
    console.log("coffeetype ="+coffeetype);
    console.log("tasteId ="+tasteId);

    if (coffeetype==""){
        alert("请输入咖啡类型");
        return;
    }

    if (tasteId==""){
        alert("请输入口味");
        return;
    }

    //需要手动验证
    $("#form").submit();
}

function validateAdd() {

    var coffeetype = $("#Coffeetype").val();
    var tasteId = $("#tasteId").val();
    console.log("coffeetype ="+coffeetype);
    console.log("tasteId ="+tasteId);

    if (coffeetype==""){
        alert("请输入咖啡类型");
        return;
    }

    if (tasteId==""){
        alert("请输入口味");
        return;
    }

    //需要手动验证
    // $("#form").submit();
    return;
}