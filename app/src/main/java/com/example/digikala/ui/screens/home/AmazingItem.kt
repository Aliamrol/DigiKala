package com.example.digikala.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.digikala.R
import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.ui.theme.DarkCyan
import com.example.digikala.ui.theme.DigikalaDarkRed
import com.example.digikala.ui.theme.DigikalaLightRed
import com.example.digikala.ui.theme.darkText
import com.example.digikala.ui.theme.extraSmall
import com.example.digikala.ui.theme.roundedShape
import com.example.digikala.ui.theme.semiDarkText
import com.example.digikala.ui.theme.spacing
import com.example.digikala.utils.DigitHelper.applyDiscount
import com.example.digikala.utils.DigitHelper.digitByLocate
import com.example.digikala.utils.DigitHelper.digitByLocateAndSeparator
import com.example.digikala.viewModel.DeviceInfoViewModel

@Composable
fun AmazingItem(item: AmazingItem, deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .width((deviceInfoViewModel.screenWidth * 0.45).dp)
            .padding(
                vertical = MaterialTheme.spacing.semiLarge,
                horizontal = MaterialTheme.spacing.semiSmall
            ), shape = MaterialTheme.roundedShape.small
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.small)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.extraSmall)
            ) {
                Text(
                    text = stringResource(R.string.amazing_for_app),
                    modifier = Modifier.padding(start = MaterialTheme.spacing.small),
                    style = MaterialTheme.typography.extraSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.DigikalaLightRed,
                )

                Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.01).dp))

                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((deviceInfoViewModel.screenHeight * 0.16).dp),
                    contentScale = ContentScale.FillBounds
                )
            }


            Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.01).dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.small)
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .height((deviceInfoViewModel.screenHeight * 0.06).dp)
                        .padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.01).dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.in_stock),
                        contentDescription = "",
                        tint = MaterialTheme.colors.DarkCyan,
                        modifier = Modifier
                            .size((deviceInfoViewModel.screenWidth * 0.06).dp)
                            .padding(2.dp)
                    )

                    Text(
                        text = item.seller,
                        style = MaterialTheme.typography.extraSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.semiDarkText
                    )
                }

                Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.01).dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .width((deviceInfoViewModel.screenWidth * 0.1).dp)
                            .height((deviceInfoViewModel.screenHeight * 0.029).dp)
                            .background(
                                color = MaterialTheme.colors.DigikalaDarkRed, shape = CircleShape
                            )
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Text(
                            text = "${digitByLocate(item.discountPercent.toString())}%",
                            color = Color.White,
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,
                        )

                    }

                    Column {
                        Row {
                            Text(
                                text = digitByLocateAndSeparator(
                                    applyDiscount(
                                        item.price,
                                        item.discountPercent
                                    ).toString()
                                ),
                                style = MaterialTheme.typography.body2,
                                fontWeight = FontWeight.SemiBold
                            )

                            Image(
                                painter = painterResource(R.drawable.toman),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(MaterialTheme.spacing.semiLarge)
                                    .padding(horizontal = MaterialTheme.spacing.extraSmall)
                            )
                        }

                        Text(
                            text = digitByLocateAndSeparator(item.price.toString()),
                            color = Color.LightGray,
                            style = MaterialTheme.typography.body2,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }

            }
        }
    }
}