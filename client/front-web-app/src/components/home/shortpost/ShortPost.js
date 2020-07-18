import React from "react";
import Button from "@material-ui/core/Button";
import Grid from "@material-ui/core/Grid";
import classes from "./ShortPost.css"

const ShortPost = ({ onViewClick, post: {id, title, images, description}}) => {

    return (
        <Grid container className={classes.ShortPost}>
            <Grid item xs={12}>
                <div className={classes.Title} onClick={()=>onViewClick(id)}>{title}</div>
            </Grid>
            <Grid item xs={4}>
                <img src={images && images[0]} alt={title} onClick={()=>onViewClick(id)}/>
            </Grid>
            <Grid item xs={8}>
                <div dangerouslySetInnerHTML={{__html: description.slice(0, 70)}}/>
                <Button
                    variant="contained"
                    color="primary"
                    margin="normal"
                    onClick={() => onViewClick(id)}
                >
                    View
                </Button>
            </Grid>
        </Grid>
    )
}

export default ShortPost;
