const API_KEY = "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"
async function fetchData() {
    const response=await fetch("https://api.openai.com/v1/completions",{
        method:"POST",
        headers:{
            Authorization:'Bearer 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',
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            model:"text-davinci-003",
            prompt:"hello ,how are you today?"
        })
    })
    const data = await response.json();
    console.log(data)
}

fetchData() 
