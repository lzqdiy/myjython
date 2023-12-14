const API_KEY = "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"
async function fetchData() {
    const response=await fetch("https://api.openai.com/v1/chat/completions",{
        method:"POST",
        headers:{
            Authorization:'Bearer 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',
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            model:"gpt-3.5-turbo",
            messages:[{
                role:"user",
                content:"who are you?"
            }]
        })
    })
    const data = await response.json();
    console.log(data)
    var content=data.choices[0].message.content
    alert("answer:"+content)
}
fetchData() ;