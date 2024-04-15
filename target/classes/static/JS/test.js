const btn = document.querySelector("#btn")

btn.addEventListener('click',()=>{
    let id = document.querySelector("#id").value
    let name = document.querySelector("#name").value
    id = id === '' ? null : id;
    name = name === '' ? null : name;
    data={
        id : id,
        name : name
    }
    sendData(`/addTest`,data)
})
