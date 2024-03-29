import React from "react"
import ContentLoader from "react-content-loader"

const CardLoader = () => (
  <ContentLoader 
    speed={2}
    width={400}
    height={460}
    viewBox="0 0 400 460"
    backgroundColor="#ecebeb"
    foregroundColor="#d6d2d2"
    
  >
    <rect x="7" y="18" rx="2" ry="2" width="300" height="300" />
  </ContentLoader>
)

export default CardLoader

