const API_KEY = "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"
async function fetchData() {
    const response=await fetch("https://api.openai.com/v1/images/generations",{
        method:"POST",
        headers:{
            Authorization:'Bearer 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',
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            prompt:"A sun",
            n:2,
            size:"1024x1024"
        })
    })
    const data = await response.json();
    console.log(data)
}
fetchData() ;